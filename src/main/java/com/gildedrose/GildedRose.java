package com.gildedrose;

import com.exceptions.InvalidQualityExceptSulfurasException;
import com.exceptions.InvalidSulfurasQualityException;

public class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void verifyQuality() throws InvalidQualityExceptSulfurasException, InvalidSulfurasQualityException {

        for (Item item: items ){
            if((item.getQuality () <0 || item.getQuality () >50) && !item.getName ().equals ("Sulfuras, Hand of Ragnaros"))
                throw new InvalidQualityExceptSulfurasException ("for the item: "+ item.getName () +" quality must be between 0 and 50");
            if(item.getName ().equals ("Sulfuras, Hand of Ragnaros"))
                throw new InvalidSulfurasQualityException ("for the item: "+ item.getName () +" quality must be equal to 80");
        }

    }
    public void updateQuality(){
        for (Item item: items){
            if(!item.getName ().equals ("Sulfuras, Hand of Ragnaros") && !item.getName ().equals ("Backstage passes")){

                if(item.getName ().equals ("Aged Brie")){
                    item.setQuality (item.getSellIn () <= 0 ? item.getQuality () - 2 : item.getQuality () + 1);
                }
                else if(item.getName ().equals ("Conjured")) {
                    item.setQuality (item.getSellIn () <= 0 ? item.getQuality () - 4 : item.getQuality () - 2);
                }
                else {
                    item.setQuality (item.getSellIn () <= 0 ? item.getQuality () - 2 : item.getQuality () - 1);
                }

                if(item.getQuality () < 0) item.setQuality (0);
            }

            if(item.getName ().equals ("Backstage passes to a TAFKAL80ETC concert")){
                if(item.getSellIn () <= 0) {
                    item.setQuality (0);
                }else {
                    if(item.getSellIn () < 11) item.setQuality (item.getQuality ()+1); //+3
                    if(item.getSellIn () < 6) item.setQuality (item.getQuality ()+1); //+2
                    item.setQuality (item.getQuality ()+1); //+1
                }
            }
            item.setSellIn (item.getSellIn ()-1);
        }
    }

}
