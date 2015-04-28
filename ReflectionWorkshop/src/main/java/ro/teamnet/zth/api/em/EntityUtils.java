package ro.teamnet.zth.api.em;

import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Andrei on 04/28/2015.
 */
public class EntityUtils {
    private EntityUtils() {
        throw new UnsupportedOperationException();
    }

    public static String getTableName(Class entity) {
        return ((Table) entity.getAnnotation(Table.class)).name();
    }

    public static List<ColumnInfo> getColumns(Class entity) {
        List<ColumnInfo> list = new ArrayList<ColumnInfo>();
        Field[] declaredFields = entity.getDeclaredFields();
        for (Field field : declaredFields) {
            ColumnInfo columnInfo = new ColumnInfo();
            Column column = field.getAnnotation(Column.class);
            Id id = field.getAnnotation(Id.class);
            if (column != null) {
                columnInfo.setIsId(false);
                columnInfo.setDbName(column.name());
                columnInfo.setColumnName(field.getName());
                columnInfo.setColumnType(field.getType());
                list.add(columnInfo);
            } else if (id != null) {
                columnInfo.setIsId(true);
                columnInfo.setDbName(id.name());
                columnInfo.setColumnName(field.getName());
                columnInfo.setColumnType(field.getType());
                list.add(columnInfo);
            }
        }
        return list;

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
}
