package com.gildedrose;

import com.exceptions.InvalidQualityExceptSulfurasException;
import com.exceptions.InvalidSulfurasQualityException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GildedRoseTest {

    @Test
    public void givenIncorrectQuality_InvalidQualityException(){
       Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 3) ,new Item("Aged Brie", 0, -1) };
       GildedRose app = new GildedRose(items);
       assertThrows (InvalidQualityExceptSulfurasException.class, app::verifyQuality);
    }

    @Test
    public void givenIncorrectQuality_InvalidSulfurasQualityException(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 70) };
        GildedRose app = new GildedRose(items);
        assertThrows (InvalidSulfurasQualityException.class, app::verifyQuality);
    }


    @Test
    public void givenCorrectQuality_beforeTheSellByDateHasPassed_agedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 22, 55) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(56, app.items[0].getQuality ());
    }

    @Test
    public void givenCorrectSellIn_agedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 22, 55) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21, app.items[0].getSellIn ());
    }

    @Test
    public void givenCorrectQuality_afterTheSellByDateHasPassed_agedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].getQuality ());
    }


    @Test
    public void givenCorrectQuality_sulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 22, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].getQuality ());
    }




    @Test
    public void givenCorrectQuality_afterTheSellByDateHasPassed_conjured() {
        Item[] items = new Item[] { new Item("Conjured", -3, 33) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(29, app.items[0].getQuality ());
    }

    @Test
    public void givenCorrectSellIn_conjured() {
        Item[] items = new Item[] { new Item("Conjured", 1, 33) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].getSellIn ());
    }
    @Test
    public void givenCorrectQuality_beforeTheSellByDateHasPassed_conjured() {
        Item[] items = new Item[] { new Item("Conjured", 1, 33) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(31, app.items[0].getQuality ());
    }


}
