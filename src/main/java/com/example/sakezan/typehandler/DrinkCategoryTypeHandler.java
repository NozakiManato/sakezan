package com.example.sakezan.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.example.sakezan.entity.DrinkCategory;

public class DrinkCategoryTypeHandler extends BaseTypeHandler<DrinkCategory> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, DrinkCategory parameter, JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter.name(), Types.OTHER);
    }

    @Override
    public DrinkCategory getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String category = rs.getString(columnName);
        return category == null ? null : DrinkCategory.valueOf(category);
    }

    @Override
    public DrinkCategory getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String category = rs.getString(columnIndex);
        return category == null ? null : DrinkCategory.valueOf(category);
    }

    @Override
    public DrinkCategory getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String category = cs.getString(columnIndex);
        return category == null ? null : DrinkCategory.valueOf(category);
    }
}
