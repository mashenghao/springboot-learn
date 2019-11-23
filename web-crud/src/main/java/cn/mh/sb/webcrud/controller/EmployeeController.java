package cn.mh.sb.webcrud.controller;

import cn.mh.sb.webcrud.common.BaseResult;
import cn.mh.sb.webcrud.dao.EmployeeDao;
import cn.mh.sb.webcrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author: mahao
 * @date: 2019/11/23
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/emps")
    public BaseResult list(int page, int offset) {
        Collection<Employee> employees = employeeDao.getAll();
        int start = (page - 1) * offset;
        if (start <= employees.size()) {
            List<Employee> list = new ArrayList<>(offset);
            Object[] array = employees.toArray();
            for (int i = start; i < array.length && i < start + offset; i++) {
                list.add((Employee) array[i]);
            }
            return BaseResult.success(list);
        }
        return BaseResult.success(Collections.EMPTY_LIST);
    }


}
