package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import java.util.ArrayList;
import java.util.List;

public class GildedRose
{

	private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
	private static final String AGED_BRIE = "Aged Brie";
	private static List<Item> listItems = null;

	/** @param args */
	public static void main(String[] args)
	{

		System.out.println("OMGHAI!");

		listItems = new ArrayList<Item>();
		listItems.add(new Item("+5 Dexterity Vest", 10, 20));
		listItems.add(new Item("Aged Brie", 2, 0));
		listItems.add(new Item("Elixir of the Mongoose", 5, 7));
		listItems.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		listItems.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15,
				20));
		listItems.add(new Item("Conjured Mana Cake", 3, 6));

		updateQualitySellinForAll();
	}

	public static void updateQualitySellinForAll()
	{
		for (int item = 0; item < listItems.size(); item++)
		{
			updateQuality(item);
			updateSellin(item);
			if (listItems.get(item).getSellIn() < 0)
			{
				updateQualityForOutdatedItem(item);
			}
		}
	}

	private static void updateQuality(int item)
	{
		if ((!AGED_BRIE.equals(getItemName(item)))
				&& !BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT
						.equals(getItemName(item)))
		{
			if (listItems.get(item).getQuality() > 0)
			{
				downQuality(item);
			}
		} else
		{
			if (listItems.get(item).getQuality() < 50)
			{
				listItems.get(item).setQuality(
						listItems.get(item).getQuality() + 1);

				upQualityBackstage(item);
			}
		}
	}

	private static void updateSellin(int item)
	{
		if (!SULFURAS_HAND_OF_RAGNAROS.equals(getItemName(item)))
		{
			listItems.get(item).setSellIn(listItems.get(item).getSellIn() - 1);
		}
	}

	private static void updateQualityForOutdatedItem(int item)
	{

		if (!AGED_BRIE.equals(getItemName(item)))
		{
			if (!BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT.equals(getItemName(item)))
			{
				if (listItems.get(item).getQuality() > 0)
				{
					downQuality(item);
				}
			} else
			{
				listItems.get(item).setQuality(listItems.get(item).getQuality() - listItems.get(item).getQuality());
			}
		} else
		{
			upQuality(item);
		}
	}

	private static void upQuality(int item)
	{
		if (listItems.get(item).getQuality() < 50)
		{
			listItems.get(item).setQuality(listItems.get(item).getQuality() + 1);
		}
	}

	private static void downQuality(int item)
	{
		if (!SULFURAS_HAND_OF_RAGNAROS.equals(getItemName(item)))
		{
			listItems.get(item)	.setQuality(listItems.get(item).getQuality() - 1);
		}
	}

	private static String getItemName(int item)
	{
		return listItems.get(item).getName();
	}

	private static void upQualityBackstage(int item)
	{
		if (BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT.equals(getItemName(item)))
		{
			if (listItems.get(item).getSellIn() < 11)
			{
				upQuality(item);
			}
		}
	}

}