package ro.teamnet.zth.api.em;

import java.sql.Statement;
import java.util.List;

/**
 * Created by Andrei on 04/28/2015.
 */
public class QueryBuilder {
    private Object tableName;
    private QueryType queryType;
    private List<ColumnInfo> queryColumns;
    private List<Condition> conditions;

    private QueryBuilder addCondition(Condition condition) {
        conditions.add(condition);
        return this;
    }

    private QueryBuilder setTableName(Object tableName) {
        this.tableName = tableName;
        return this;
    }

    private QueryBuilder addQueryColumns(List<ColumnInfo> queryColumns) {
        this.queryColumns = queryColumns;
        return this;
    }

    private QueryBuilder setQueryType(QueryType queryType) {
        this.queryType = queryType;
        return this;
    }

    public String createQuery(QueryType queryType, Object tableName, List<ColumnInfo> queryColumns, List<Condition> conditions) {
        if (queryType.equals(QueryType.SELECT)) {
            return createSelectQuery(tableName, queryColumns, conditions);
        } else if (queryType.equals(QueryType.DELETE)) {
            return createDeleteQuery(tableName, conditions);
        } else if (queryType.equals(QueryType.INSERT)) {
            return createInsertQuery(tableName, queryColumns, conditions);
        } else if (queryType.equals(QueryType.UPDATE)) {
            return createUpdateQuery(tableName, queryColumns, conditions);
        }
        return null;
    }

    public String createDeleteQuery(Object tableName, List<Condition> conditions) {
        StringBuilder sB = new StringBuilder();
        sB.append("DELETE FROM " + tableName.toString() + "\nWHERE ");
        if (conditions.size() > 1) {
            for (int i = 0; i < conditions.size(); i++) {
                if (i == conditions.size() - 1) {
                    sB.append(conditions.get(i).getColumnName() + " = " + conditions.get(i).getValue());
                } else {
                    sB.append(conditions.get(i).getColumnName() + " = " + conditions.get(i).getValue() + " AND ");
                }
            }
        } else {
            sB.append(conditions.get(0).getColumnName() + " = " + conditions.get(0).getValue());
        }


        return sB.toString();
    }

    public String createInsertQuery(Object tableName, List<ColumnInfo> queryColumns, List<Condition> conditions) {
        StringBuilder sB = new StringBuilder();
        sB.append("INSERT INTO " + tableName.toString() + " (");
        if (queryColumns != null) {
            for (int i = 0; i < queryColumns.size(); i++) {
                if (i < queryColumns.size() - 1)
                    sB.append(queryColumns.get(i).getDbName() + ", ");
                else
                    sB.append(queryColumns.get(i).getDbName());
            }
            sB.append(")");
        }
        sB.append("\nVALUES (");
        if (conditions != null) {
            for (int i = 0; i < conditions.size(); i++) {
                Condition c = conditions.get(i);
                if (i != conditions.size() - 1) {
                    sB.append(c.getValue() + ", ");
                } else {
                    sB.append(c.getValue() + ")");
                }
            }
        }

        return sB.toString();
    }

    public String createUpdateQuery(Object tableName, List<ColumnInfo> queryColumns, List<Condition> conditions) {
        StringBuilder sB = new StringBuilder();
        sB.append("UPDATE " + tableName.toString() + "\nSET ");
        if (queryColumns != null) {
            for (int i = 0; i < queryColumns.size(); i++) {
                if (i < queryColumns.size() - 1)
                    sB.append(queryColumns.get(i).getDbName() + " = " + queryColumns.get(i).getValue() + ", ");
                else
                    sB.append(queryColumns.get(i).getDbName() + " = " + queryColumns.get(i).getValue());
            }
        }
        if (conditions != null) {
            sB.append("\nWHERE ");
            for (int i = 0; i < conditions.size(); i++) {
                Condition c = conditions.get(i);
                if (i != conditions.size() - 1) {
                    sB.append(c.getColumnName() + " = " + c.getValue() + " AND ");
                } else {
                    sB.append(c.getColumnName() + " = " + c.getValue());
                }
            }
        }
        return sB.toString();
    }

    public String createSelectQuery(Object tableName, List<ColumnInfo> queryColumns, List<Condition> conditions) {
        StringBuilder sB = new StringBuilder();
        sB.append("SELECT ");
        if (queryColumns != null) {
            for (int i = 0; i < queryColumns.size(); i++) {
                if (i < queryColumns.size() - 1)
                    sB.append(queryColumns.get(i).getDbName() + ", ");
                else
                    sB.append(queryColumns.get(i).getDbName());
            }
        } else {
            sB.append("*");
        }
        sB.append(" FROM " + tableName.toString());
        if (conditions != null) {
            sB.append("\nWHERE ");
            for (int i = 0; i < conditions.size(); i++) {
                Condition c = conditions.get(i);
                if (i != conditions.size() - 1) {
                    sB.append(c.getColumnName() + " = " + c.getValue() + " AND ");
                } else {
                    sB.append(c.getColumnName() + " = " + c.getValue());
                }
            }
        }
        return sB.toString();
    }
}
