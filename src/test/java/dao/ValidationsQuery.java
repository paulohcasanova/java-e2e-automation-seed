package dao;

import constants.QueryEnum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationsQuery {
    DbConnection conn;
    public ValidationsQuery(){
        this.conn = new DbConnection();
    }

    public void close(){
        try {
            this.conn.closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean validateSomethingInDatabase(String quantity, String filterParameter1, String filterParameter2) throws SQLException {
       return queryHandler(
                String.format(QueryEnum.exampleQuery, filterParameter2, filterParameter1),
                "COLUMN_NAME",
                quantity
        );
    }

    public boolean validateSomethingInDatabase_MoreThanOneColumn(String filterParam1, String validationParam1, String validationParam2) throws SQLException {
        HashMap<String, String> columnsToValidate = new HashMap<String, String>();
        columnsToValidate.put("COLUMN_1", validationParam1);
        columnsToValidate.put("COLUMN_2", validationParam2);

        return queryHandler(
                String.format(QueryEnum.exampleQuery, filterParam1),
                columnsToValidate
        );
    }

    //region Helpers
    private boolean queryHandler(String query, String columnToValidate, String valueToValidate) throws SQLException {
        ResultSet result = conn.runQuery(query);

        while(result.next()){
            String dbQuantity = result.getString(columnToValidate);

            if(dbQuantity.equals(valueToValidate)){
                result.close();
                return true;
            }
        }
        result.close();
        return false;
    }

    private boolean queryHandler(String query, HashMap<String, String> columnToValidate) throws SQLException {
        List<Boolean> resultList = new ArrayList<>();
        ResultSet result = conn.runQuery(query);

        while(result.next()){
            for(Map.Entry<String, String> entry : columnToValidate.entrySet()){
                try {
                    String dbValue = result.getString(entry.getKey());
                    if(dbValue.equals(entry.getValue())){
                        resultList.add(true);
                    }
                    else {
                        resultList.add(false);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        result.close();
        return resultList.contains(false);
    }
    //endregion
}
