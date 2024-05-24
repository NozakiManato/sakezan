package com.example.sakezan.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import com.example.sakezan.entity.Role;


public class RoleTypeHandler extends BaseTypeHandler<Role> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Role parameter, JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter.name(), Types.OTHER);
    }

    @Override
    public Role getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String role = rs.getString(columnName);
        return role == null ? null : Role.valueOf(role);
    }

    @Override
    public Role getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String role = rs.getString(columnIndex);
        return role == null ? null : Role.valueOf(role);
    }

    @Override
    public Role getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String role = cs.getString(columnIndex);
        return role == null ? null : Role.valueOf(role);
    }
}
