package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei on 04/28/2015.
 */
public class EntityUtils {
    public static final String EMPTY_STRING = "";

    private EntityUtils() {
        throw new UnsupportedOperationException();
    }

    public static String getTableName(Class entity) {
        Table tableAnnotation = (Table) entity.getAnnotation(Table.class);
        return EMPTY_STRING.equals(tableAnnotation.name()) ? entity.getClass().getSimpleName() : tableAnnotation.name();
    }

    public static List<ColumnInfo> getColumns(Class entity, boolean withJoins) {
        List<ColumnInfo> columns = new ArrayList<ColumnInfo>();
        Field[] declaredFields = entity.getDeclaredFields();
        for (Field field : declaredFields) {
            Column column = field.getAnnotation(Column.class);
            ColumnInfo columnInfo = new ColumnInfo();
            columnInfo.setColumnName(field.getName());
            columnInfo.setColumnType(field.getType());
            if (column != null) {
                columnInfo.setDbName(column.name());
            } else {
                Id id = field.getAnnotation(Id.class);
                columnInfo.setDbName(id.name());
                columnInfo.setIsId(true);
            }
            if (withJoins) {
                //ToDo
            }
            columns.add(columnInfo);
        }
        return columns;
    }

    public static List<Field> getFieldsByAnnotations(Class clazz, Class annotation) {
        Field[] declaredFields = clazz.getDeclaredFields();
        List<Field> list = new ArrayList<Field>();
        for (Field declaredField : declaredFields) {
            if (declaredField.getAnnotation(annotation) != null) {
                list.add(declaredField);
            }
        }
        return list;
    }

    public static List<ColumnInfo> getColumns(Class entity) {
        return getColumns(entity, true);
    }

    public static Object getSqlValue(Object object) throws IllegalAccessException {
        if (object == null) {
            return null;
        }
        if (object.getClass().getAnnotation(Table.class) != null) {
            Field idField = getFieldsByAnnotations(object.getClass(), Id.class).get(0);
            idField.setAccessible(true);
            return idField.get(object);
        } else {
            return object;
        }
    }
}
