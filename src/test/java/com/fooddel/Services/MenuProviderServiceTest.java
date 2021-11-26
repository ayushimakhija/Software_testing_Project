package com.fooddel.Services;
import com.fooddel.beans.Customer;
import com.fooddel.beans.Menu;
import com.fooddel.beans.foodprovider;
import com.fooddel.repository.MenuRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.awt.SystemColor.menu;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MenuProviderServiceTest {
    @Mock
    MenuRepository Mp ;

    @InjectMocks
    MenuService ms = new MenuService();

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test_path1234536PositiveCase() {
        System.out.println("testpath1");
        foodprovider f2 = new foodprovider("pavan@gmail.com","pavan","bangalore","Pavan Tifffins","8686886135");
        f2.setFood_Id(4);
        when(Mp.findAll()).thenReturn(List.of(new Menu("Aloo Gobi", "Delicious aloo gobi", "chbhbd", "230", "thursday",f2)));
        List<List<String>> expectedMenu = new ArrayList<>();
        List<String> m2 = new ArrayList<>();
        m2.add("Aloo Gobi");
        m2.add("Delicious aloo gobi");
        m2.add("chbhbd");
        m2.add("230");
        m2.add("thursday");
        expectedMenu.add(m2);
        assertEquals(expectedMenu,ms.getListOfMenuOfParticularFoodProvider(4));
    }

    @Test
    public void test_path1234536NegativeCase() {
        System.out.println("testpath2");
        foodprovider f2 = new foodprovider("pavan@gmail.com","pavan","bangalore","Pavan Tifffins","8686886135");
        f2.setFood_Id(4);
        when(Mp.findAll()).thenReturn(List.of(new Menu("Aloo Gobi", "Delicious aloo gobi", "chbhbd", "230", "thursday",f2)));
        List<List<String>> expectedMenu = new ArrayList<>();
        List<String> m2 = new ArrayList<>();
        m2.add("Chicken biryani");
        m2.add("Delicious chick engobi");
        m2.add("chbhbd");
        m2.add("230");
        m2.add("thursday");
        expectedMenu.add(m2);
        assertNotEquals(expectedMenu,ms.getListOfMenuOfParticularFoodProvider(4));
    }

    @Test
    public void test_path123436PositiveCase() {
        System.out.println("testpath3");
        foodprovider f5 =  new foodprovider("chirag16@gmail.com","chirag","jabalpur","chirag Cafe","9875647839");
        f5.setFood_Id(2);
        when(Mp.findAll()).thenReturn(List.of());
        List<List<String>> expectedMenu = new ArrayList<>();
        List<String> m2 = new ArrayList<>();
        expectedMenu.add(m2);
        assertEquals(m2,ms.getListOfMenuOfParticularFoodProvider(2));
    }

    @Test
    public void test_path123436NegativeCase() {
        System.out.println("testpath3");
        foodprovider f5 =  new foodprovider("chirag16@gmail.com","chirag","jabalpur","chirag Cafe","9875647839");
        f5.setFood_Id(2);
        when(Mp.findAll()).thenReturn(List.of());
        List<List<String>> expectedMenu = new ArrayList<>();
        List<String> m2 = new ArrayList<>();
        m2.add("adarsh");
        expectedMenu.add(m2);
        assertNotEquals(m2,ms.getListOfMenuOfParticularFoodProvider(2));
    }

    @Test
    public void test_path1236PositiveCase() {
        System.out.println("testpath3");
        when(Mp.findAll()).thenReturn(List.of());
        List<List<String>> expectedMenu = new ArrayList<>();
        List<String> m2 = new ArrayList<>();
        expectedMenu.add(m2);
        assertEquals(m2,ms.getListOfMenuOfParticularFoodProvider(8));
    }

    @Test
    public void test_path1236NegativeCase() {
        System.out.println("testpath3");
        when(Mp.findAll()).thenReturn(List.of());
        List<List<String>> expectedMenu = new ArrayList<>();
        List<String> m2 = new ArrayList<>();
        expectedMenu.add(m2);
        m2.add("Aloo gobi");
        m2.add("246");
        assertNotEquals(m2,ms.getListOfMenuOfParticularFoodProvider(8));
    }

    @Test
    public void test_path1234534536PositiveCase() {
        System.out.println("testpath4");
        foodprovider f1 =  new foodprovider("ayushi9yb.19@gmail.com","ayushi","bangalore","ayushi Cafe","7869054251");
        f1.setFood_Id(1);
        when(Mp.findAll()).thenReturn(List.of(new Menu("pizza","Delicious fresh pan Pizza","chbhbd","230","sunday",f1),new Menu("pasta","Italian pasta","chbhbck","200","monday",f1)));
        List<List<String>> expectedMenu = new ArrayList<>();
        List<String> m2 = new ArrayList<>();
        m2.add("pizza");
        m2.add("Delicious fresh pan Pizza");
        m2.add("chbhbd");
        m2.add("230");
        m2.add("sunday");
        expectedMenu.add(m2);
        List<String> m3 = new ArrayList<>();
        m3.add("pasta");
        m3.add("Italian pasta");
        m3.add("chbhbck");
        m3.add("200");
        m3.add("monday");
        expectedMenu.add(m3);
        assertEquals(expectedMenu,ms.getListOfMenuOfParticularFoodProvider(1));
    }

    @Test
    public void test_path1234534536NegativeCase() {
        System.out.println("testpath4");
        foodprovider f1 =  new foodprovider("ayushi9yb.19@gmail.com","ayushi","bangalore","ayushi Cafe","7869054251");
        f1.setFood_Id(1);
        when(Mp.findAll()).thenReturn(List.of(new Menu("pizza","Delicious fresh pan Pizza","chbhbd","230","sunday",f1),new Menu("pasta","Italian pasta","chbhbck","200","monday",f1)));
        List<List<String>> expectedMenu = new ArrayList<>();
        List<String> m3 = new ArrayList<>();
        m3.add("pasta");
        m3.add("Italian pasta");
        m3.add("chbhbck");
        m3.add("200");
        m3.add("monday");
        expectedMenu.add(m3);
        List<String> m2 = new ArrayList<>();
        m2.add("pizza");
        m2.add("Delicious fresh pan Pizza");
        m2.add("chbhbd");
        m2.add("230");
        m2.add("sunday");
        expectedMenu.add(m2);
        assertNotEquals(expectedMenu,ms.getListOfMenuOfParticularFoodProvider(1));
    }

    @Test
    public void test_path123453436PositiveCase(){
        System.out.println("testpath5");
        foodprovider f4 =  new foodprovider("mehak@gmail.com","mehak","hyderabad","Mehak Sweets","9269054251");
        f4.setFood_Id(6);
        when(Mp.findAll()).thenReturn(List.of(new Menu("Chole Bature","Delicious chole bature","chbhbck","230","saturday",f4)));
        List<List<String>> expectedMenu = new ArrayList<>();
        List<String> m2 = new ArrayList<>();
        m2.add("Chole Bature");
        m2.add("Delicious chole bature");
        m2.add("chbhbck");
        m2.add("230");
        m2.add("saturday");
        expectedMenu.add(m2);
        assertNotNull(ms.getListOfMenuOfParticularFoodProvider(6));
        assertEquals(expectedMenu,ms.getListOfMenuOfParticularFoodProvider(6));

    }

    @Test
    public void test_path123453436NegativeCase(){
        System.out.println("testpath5");
        foodprovider f4 =  new foodprovider("mehak@gmail.com","mehak","hyderabad","Mehak Sweets","9269054251");
        f4.setFood_Id(6);
        when(Mp.findAll()).thenReturn(List.of(new Menu("Chole Bature","Delicious chole bature","chbhbck","230","saturday",f4)));
        List<List<String>> expectedMenu = new ArrayList<>();
        List<String> m2 = new ArrayList<>();
        m2.add("Chole Bature");
        m2.add("Delicious chole bature");
        m2.add("chbhbck");
        m2.add("230");
        m2.add("Friday");
        expectedMenu.add(m2);
        //assertNotNull(ms.getListOfMenuOfParticularFoodProvider(6));
        assertNotEquals(expectedMenu,ms.getListOfMenuOfParticularFoodProvider(6));

    }

    @Test
    public void test_path12343436PositiveCase(){
        System.out.println("testpath2");
        foodprovider f5 =  new foodprovider("chirag16@gmail.com","chirag","jabalpur","chirag Cafe","9875647839");
        f5.setFood_Id(7);
        when(Mp.findAll()).thenReturn(List.of());
        List<List<String>> expectedMenu = new ArrayList<>();
        List<String> m2 = new ArrayList<>();
        expectedMenu.add(m2);
        //assertNull(ms.getListOfMenuOfParticularFoodProvider(7));
        assertEquals(m2,ms.getListOfMenuOfParticularFoodProvider(7));
    }

    @Test
    public void test_path12343436NegativeCase(){
        System.out.println("testpath2");
        foodprovider f5 =  new foodprovider("chirag16@gmail.com","chirag","jabalpur","chirag Cafe","9875647839");
        f5.setFood_Id(7);
        when(Mp.findAll()).thenReturn(List.of());
        List<List<String>> expectedMenu = new ArrayList<>();
        List<String> m2 = new ArrayList<>();
        m2.add("pizza");
        m2.add("WOW pizza");
        m2.add("456");
        expectedMenu.add(m2);
        //assertNull(ms.getListOfMenuOfParticularFoodProvider(7));
        assertNotEquals(m2,ms.getListOfMenuOfParticularFoodProvider(7));
    }

}
