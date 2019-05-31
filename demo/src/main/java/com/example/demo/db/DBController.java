package com.example.demo.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@RestController
public class DBController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @RequestMapping("/cq")
    public int complexQuery() {
        List<Map<String,Object>> result = jdbcTemplate.queryForList("select * from BIZX_BIZXTEST.RULE");
        return result.size();
    }

    /**
     * cause OOM Error
     * @return
     */
    @RequestMapping("/oom-error")
    public int complexQuery1() {
        List<Map<String,Object>> result = jdbcTemplate.queryForList("select * from BIZX_BIZXTEST.GENERIC_OBJECT_T");
        return result.size();
    }

    @RequestMapping("/cq2")
    public int complexQuery2() {
        List<Map<String,Object>> result = jdbcTemplate.queryForList("select * from BIZX_BIZXTEST.GENERIC_OBJECT_T where ROW_ID=1890062");
        return result.size();
    }

    @RequestMapping("/cq3")
    public int complexQuery3() {
        List<Map<String,Object>> result = jdbcTemplate.queryForList("WITH STARTS AS ( SELECT ROW_ID FROM BIZX_BIZXTEST.GENERIC_OBJECT_T WHERE ROW_ID IN (1890062)),\n" +
                "     ENDS AS  (select result_node,distance as level from BIZX_BIZXTEST.GENERIC_OBJECT_T_ROWID_HVIEW('expression'='descendants( :STARTS )')\n" +
                "     order by level NULLS LAST ,result_node NULLS LAST  )\n" +
                "     SELECT T0.PARENT_ROW_ID F1, (select level from ENDS where result_node = T0.ROW_ID) F2,\n" +
                "     T0.CUSTOM_FIELD4 F3 FROM BIZX_BIZXTEST.GENERIC_OBJECT_T T0 where\n" +
                "    (OBJECT_TYPE_ID in (1,2))\n" +
                "    AND T0.ROW_ID IN (select result_node from ENDS)\n" +
                "     ORDER BY F2 ASC NULLS LAST");
        return result.size();
    }

    @RequestMapping("/cq4")
    public int complexQuery4() {
        List<Map<String,Object>> result = jdbcTemplate.queryForList("SELECT ROW_ID FROM BIZX_BIZXTEST.GENERIC_OBJECT_T WHERE ROW_ID IN (1890062)),\n" +
                "     ENDS AS  (select result_node,distance as level from BIZX_BIZXTEST.GENERIC_OBJECT_T_ROWID_HVIEW('expression'='descendants( :STARTS )')\n" +
                "     order by level NULLS LAST ,result_node NULLS LAST  )\n" +
                "     SELECT T0.PARENT_ROW_ID F1, (select level from ENDS where result_node = T0.ROW_ID) F2,\n" +
                "     T0.CUSTOM_FIELD4 F3 FROM BIZX_BIZXTEST.GENERIC_OBJECT_T T0 where\n" +
                "    (OBJECT_TYPE_ID in (1,2))\n" +
                "    AND T0.ROW_ID IN (select result_node from ENDS)\n" +
                "     ORDER BY F2 ASC");
        return result.size();
    }

    @RequestMapping("/cq5")
    @Transactional
    public int complexQuery5() {
        List<Map<String,Object>> result = jdbcTemplate.queryForList("select * from BIZX_BIZXTEST.GENERIC_OBJECT_T where ROW_ID=1890062");
        return result.size();
    }

}
