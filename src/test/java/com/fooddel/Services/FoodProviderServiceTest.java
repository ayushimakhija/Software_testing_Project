package com.fooddel.Services;
import com.fooddel.beans.Menu;
import com.fooddel.beans.foodprovider;
import com.fooddel.repository.FoodProviderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FoodProviderServiceTest {

    @Mock
    FoodProviderRepository foodProviderRepository;

    @InjectMocks
    foodProviderService fps = new foodProviderService();

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
   //Edge-Cover
    @Test
    public void Test_path1235PositiveCase() {
        System.out.println("testpath1");
        when(foodProviderRepository.findByLocation("jabalpur")).thenReturn(List.of());
        List<String> expectedMenu = new ArrayList<>();
        assertEquals(expectedMenu,fps.getFoodProvidersdishNameByLocation("jabalpur"));
    }

    @Test
    public void Test_path1235FalseCase() {
        System.out.println("testpath2");
        when(foodProviderRepository.findByLocation("jabalpur")).thenReturn(List.of());
        List<String> expectedMenu = new ArrayList<>();
        expectedMenu.add("Ayushi Cafe");
        assertNotEquals(expectedMenu,fps.getFoodProvidersdishNameByLocation("jabalpur"));
    }

    @Test
    public void Test_path123436PositiveCase() {
        System.out.println("testpath3");
        when(foodProviderRepository.findByLocation("hyderabad")).thenReturn(List.of(new foodprovider("mehak@gmail.com","mehak","hyderabad","Mehak Sweets","9269054251")));
        List<String> expectedMenu = new ArrayList<>();
        expectedMenu.add("Mehak Sweets");
        assertEquals(expectedMenu,fps.getFoodProvidersdishNameByLocation("hyderabad"));

    }

    @Test
    public void Test_path123436NegativeCase() {
        System.out.println("testpath4");
        when(foodProviderRepository.findByLocation("hyderabad")).thenReturn(List.of(new foodprovider("mehak@gmail.com","mehak","hyderabad","Mehak Sweets","9269054251")));
        List<String> expectedMenu = new ArrayList<>();
        expectedMenu.add("Chirag Cafe");
        //assertNull(fps.getFoodProvidersdishNameByLocation("hyderabad"));
        assertNotEquals(expectedMenu,fps.getFoodProvidersdishNameByLocation("hyderabad"));

    }


    @Test
    public void Test_path12343436PositiveCase() {
        System.out.println("testpath3");
        when(foodProviderRepository.findByLocation("chennai")).thenReturn(List.of(new foodprovider("pavan@gmail.com","pavan","chennai","Pavan Tifffins","8686886135"),new foodprovider("shabbir@gmail.com","shabbir","chennai","SS Chicken Biryani","7823456789")));
        List<String> expectedMenu = new ArrayList<>();
        expectedMenu.add("Pavan Tifffins");
        expectedMenu.add("SS Chicken Biryani");
        //assertNull(fps.getFoodProvidersdishNameByLocation("hyderabad"));
        assertEquals(expectedMenu,fps.getFoodProvidersdishNameByLocation("chennai"));

    }

    @Test
    public void Test_path12343436NegativeCase() {
        System.out.println("testpath3");
        when(foodProviderRepository.findByLocation("chennai")).thenReturn(List.of(new foodprovider("pavan@gmail.com","pavan","chennai","Pavan Tifffins","8686886135"),new foodprovider("shabbir@gmail.com","shabbir","chennai","SS Chicken Biryani","7823456789")));
        List<String> expectedMenu = new ArrayList<>();
        expectedMenu.add("Pavan Sexy Cafe");
        expectedMenu.add("SS Chicken Biryani");
        assertNotEquals(expectedMenu,fps.getFoodProvidersdishNameByLocation("chennai"));

    }

}
