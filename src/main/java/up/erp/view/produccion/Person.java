/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package up.erp.view.produccion;

/**
 *
 * @author Upgrade - PC
 */
public class Person implements Cloneable{
    
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public Person() {

    }

    public Person(int id, String firstName, String lastName, int age) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

    }
    
    public String getName()
    {
        return this.firstName;
    }
    
    public String getFirstName()
    {
        return this.lastName;
    }

}
