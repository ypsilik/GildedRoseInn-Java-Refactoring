package fr.iutvalence.info.dut.m3105.gildedroseinn.refactoring;

import java.util.ArrayList;
import java.util.List;

public class GildedRose
{

	private static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
	private static final String AGED_BRIE = "Aged Brie";
	private static List<Item> listItems = null;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		System.out.println("OMGHAI!");

		listItems = new ArrayList<Item>();
		listItems.add(new Item("+5 Dexterity Vest", 10, 20));
		listItems.add(new Item("Aged Brie", 2, 0));
		listItems.add(new Item("Elixir of the Mongoose", 5, 7));
		listItems.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		listItems.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		listItems.add(new Item("Conjured Mana Cake", 3, 6));

		itemGestion();
	}

	public static void itemGestion()
	{
		for (int i = 0; i < listItems.size(); i++)
		{
			qualitytest(i);

			if (!SULFURAS_HAND_OF_RAGNAROS.equals(listItems.get(i).getName()))
			{
				listItems.get(i).setSellIn(listItems.get(i).getSellIn() - 1);
			}

			sellIntest(i);
		}
	}

	private static void sellIntest(int item)
	{
		if (listItems.get(item).getSellIn() < 0)
		{
			if (!AGED_BRIE.equals(listItems.get(item).getName()))
			{
				if (!BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT.equals(listItems.get(item).getName()))
				{
					if (listItems.get(item).getQuality() > 0)
					{
						changeQuality(item);
					}
				}
				else
				{
					listItems.get(item).setQuality(listItems.get(item).getQuality() - listItems.get(item).getQuality());
				}
			}
			else
			{
				if (listItems.get(item).getQuality() < 50)
				{
					listItems.get(item).setQuality(listItems.get(item).getQuality() + 1);
				}
			}
		}
	}

	private static void changeQuality(int item)
	{
		if (!SULFURAS_HAND_OF_RAGNAROS.equals(listItems.get(item).getName()))
		{
			listItems.get(item).setQuality(listItems.get(item).getQuality() - 1);
		}
	}

	private static void qualitytest(int i)
	{
		if ((!AGED_BRIE.equals(listItems.get(i).getName()))
				&& !BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT.equals(listItems.get(i).getName()))
		{
			if (listItems.get(i).getQuality() > 0)
			{
				changeQuality(i);
			}
		}
		else
		{
			if (listItems.get(i).getQuality() < 50)
			{
				listItems.get(i).setQuality(listItems.get(i).getQuality() + 1);

				if (BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT.equals(listItems.get(i).getName()))
				{
					if (listItems.get(i).getSellIn() < 11)
					{
						if (listItems.get(i).getQuality() < 50)
						{
							listItems.get(i).setQuality(listItems.get(i).getQuality() + 1);
						}
					}

					if (listItems.get(i).getSellIn() < 6)
					{
						if (listItems.get(i).getQuality() < 50)
						{
							listItems.get(i).setQuality(listItems.get(i).getQuality() + 1);
						}
					}
				}
			}
		}
	}

}