package com.zappos.giftideas.optimalselection;

import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.zappos.giftideas.optimalselection.entity.Product;
import com.zappos.giftideas.optimalselection.entity.ProductList;

@RunWith(MockitoJUnitRunner.class)
public class OptimalSelectionTest {
    @InjectMocks
    private OptimalSelection optimalSelection = new OptimalSelection();
    @Mock
    private ZapposAPIHandler handler;

    @Test
    public void testNoProductsWithZappos() throws Exception {
        when(handler.search(anyDouble(), anyInt())).thenReturn(new ArrayList<Product>());
        List<ProductList> list = optimalSelection.getOptimalSelection(13.0, 2);
        Assert.assertTrue(list.size() == 0);
    }

    @Test
    public void testSomeProductsWithZappos() throws Exception {
        List<Product> dummyProducts = new ArrayList<>();
        dummyProducts.add(new Product("p1", "123", 1.0));
        dummyProducts.add(new Product("p2", "124", 2.0));
        dummyProducts.add(new Product("p3", "125", 3.0));
        dummyProducts.add(new Product("p4", "126", 8.0));
        dummyProducts.add(new Product("p5", "127", 12.0));
        when(handler.search(anyDouble(), anyInt())).thenReturn(new ArrayList<Product>());
        when(handler.search(anyDouble(), eq(0))).thenReturn(dummyProducts);
        List<ProductList> list = optimalSelection.getOptimalSelection(12.0, 3);
        Assert.assertEquals(2, list.size());
    }
}