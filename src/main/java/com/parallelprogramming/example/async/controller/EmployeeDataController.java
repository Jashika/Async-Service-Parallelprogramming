package com.parallelprogramming.example.async.controller;

import java.util.ArrayList;
import java.util.List;

import com.parallelprogramming.example.async.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeDataController
{
    private static Logger log = LoggerFactory.getLogger(EmployeeDataController.class);

    @RequestMapping(value = "/addresses", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeAddress>> getAddresses()
    {
        log.info("get addresses Start");

        EmployeeAddress employeeAddress1 = new EmployeeAddress();
        EmployeeAddress employeeAddress2 = new EmployeeAddress();

        List<EmployeeAddress> addressList = new ArrayList<EmployeeAddress>();

            employeeAddress1.setHouseNo("1111");
            employeeAddress1.setStreetNo("111");
            employeeAddress1.setZipCode("111111");

            employeeAddress2.setHouseNo("222");
            employeeAddress2.setStreetNo("222");
            employeeAddress2.setZipCode("222222");

            addressList.add(employeeAddress1);
            addressList.add(employeeAddress2);
        ResponseEntity<List<EmployeeAddress>> addresses = new ResponseEntity<>(addressList, HttpStatus.OK);
        return addresses;

    }

    @RequestMapping(value = "/phones", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeePhoneNumber>>  getPhoneNumbers()
    {
        log.info("get phones Start");
        EmployeePhoneNumber employeePhoneNumber1 = new EmployeePhoneNumber();
        EmployeePhoneNumber employeePhoneNumber2 = new EmployeePhoneNumber();

        List<EmployeePhoneNumber> employeePhoneNumberList = new ArrayList<EmployeePhoneNumber>();
            employeePhoneNumber1.setPhoneNumber("246221");
            employeePhoneNumber2.setPhoneNumber("246223");

        employeePhoneNumberList.add(employeePhoneNumber1);
        employeePhoneNumberList.add(employeePhoneNumber2);
        ResponseEntity<List<EmployeePhoneNumber>> phoneNumbers = new ResponseEntity<>(employeePhoneNumberList, HttpStatus.OK);
        return phoneNumbers;

    }

    @RequestMapping(value = "/names", method = RequestMethod.GET)
    public ResponseEntity<List<EmployeeName>> getEmployeeName()
    {
        log.info("get names Start");

        EmployeeName employeeNamesList = new EmployeeName();

        EmployeeName employeeName1 = new EmployeeName();
        EmployeeName employeeName2 = new EmployeeName();

        List<EmployeeName> employeeNameList = new ArrayList<EmployeeName>();
            employeeName1.setFirstName("Santa");
            employeeName1.setLastName("Singh");
            employeeName2.setFirstName("Banta");
            employeeName2.setLastName("Singh");

        employeeNameList.add(employeeName1);
        employeeNameList.add(employeeName2);
        ResponseEntity<List<EmployeeName>> empNames = new ResponseEntity<>(employeeNameList, HttpStatus.OK);
        return empNames;
    }
}
