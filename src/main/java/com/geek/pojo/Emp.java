package com.geek.pojo;

import java.util.Date;

/**
 * 员工
 */
public class Emp {
    private Integer empId;
    private String account;
    private String password;
    private String empName;
    private Integer sex;
    private Integer depId;
    private Date hireDate;
    private String head;
    private String education;
    private String card;
    private String politic;
    private String school;
    private String marriage;
    private String phone;
    private String email;
    private String registratin;
    private String position;
    private String isDeparture;
    private Dep dep;

    public Emp() {
    }

    public Emp(Integer empId, String account, String password, String empName, Integer sex, Integer depId, Date hireDate, String head, String education, String card, String politic, String school, String marriage, String phone, String email, String registratin, String position, String isDeparture) {
        this.empId = empId;
        this.account = account;
        this.password = password;
        this.empName = empName;
        this.sex = sex;
        this.depId = depId;
        this.hireDate = hireDate;
        this.head = head;
        this.education = education;
        this.card = card;
        this.politic = politic;
        this.school = school;
        this.marriage = marriage;
        this.phone = phone;
        this.email = email;
        this.registratin = registratin;
        this.position = position;
        this.isDeparture = isDeparture;
    }

    public Emp(Integer empId, String account, String password, String empName, Integer sex, Integer depId, Date hireDate, String head, String education, String card, String politic, String school, String marriage, String phone, String email, String registratin, String position, String isDeparture, Dep dep) {
        this.empId = empId;
        this.account = account;
        this.password = password;
        this.empName = empName;
        this.sex = sex;
        this.depId = depId;
        this.hireDate = hireDate;
        this.head = head;
        this.education = education;
        this.card = card;
        this.politic = politic;
        this.school = school;
        this.marriage = marriage;
        this.phone = phone;
        this.email = email;
        this.registratin = registratin;
        this.position = position;
        this.isDeparture = isDeparture;
        this.dep = dep;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Dep getDep() {
        return dep;
    }

    public void setDep(Dep dep) {
        this.dep = dep;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getPolitic() {
        return politic;
    }

    public void setPolitic(String politic) {
        this.politic = politic;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegistratin() {
        return registratin;
    }

    public void setRegistratin(String registratin) {
        this.registratin = registratin;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIsDeparture() {
        return isDeparture;
    }

    public void setIsDeparture(String isDeparture) {
        this.isDeparture = isDeparture;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", empName='" + empName + '\'' +
                ", sex=" + sex +
                ", depId=" + depId +
                ", hireDate=" + hireDate +
                ", head='" + head + '\'' +
                ", education='" + education + '\'' +
                ", card='" + card + '\'' +
                ", politic='" + politic + '\'' +
                ", school='" + school + '\'' +
                ", marriage='" + marriage + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", registratin='" + registratin + '\'' +
                ", position='" + position + '\'' +
                ", isDeparture='" + isDeparture + '\'' +

                '}';
    }
}
