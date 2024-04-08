/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.arquitecturas.testWS;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "persona")
@XmlType(propOrder = {"id", "fullName", "age", "salario"})
public class Persona {
    private int id;
    private String fullName;
    private int age;
    private int salario;
    private int Salario_Minimo_;

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @XmlElement
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = age*Salario_Minimo_/3;
    }

    public int getSalario_Minimo_() {
        return Salario_Minimo_;
    }

    public void setSalario_Minimo_(int Salario_Minimo_) {
        this.Salario_Minimo_ = Salario_Minimo_;
    }
}
