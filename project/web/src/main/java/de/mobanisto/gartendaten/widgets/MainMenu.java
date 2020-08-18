package de.mobanisto.gartendaten.widgets;

import static de.topobyte.jsoup.HTML.a;

import de.topobyte.cachebusting.CacheBusting;
import de.topobyte.jsoup.HTML;
import de.topobyte.jsoup.bootstrap4.components.Expand;
import de.topobyte.jsoup.bootstrap4.components.Menu;
import de.topobyte.jsoup.bootstrap4.components.MenuBuilder;
import de.topobyte.jsoup.components.A;
import de.topobyte.jsoup.components.Img;
import de.topobyte.jsoup.nodes.Element;
import de.topobyte.pagegen.core.LinkResolver;
import de.topobyte.webpaths.WebPaths;

public class MainMenu
{

	public static Menu create(LinkResolver resolver)
	{
		MenuBuilder builder = new MenuBuilder();
		builder.setExpand(Expand.MD).setFixed(true);
		Menu menu = builder.create();

		menu.addClass("shadow-sm");

		A brand = a("/");

		Img image = HTML.img(
				"/" + WebPaths.get(CacheBusting.resolve("images/icon.svg")));
		image.attr("height", "40px");
		image.attr("style", "padding-right:15px");
		brand.ap(image);

		brand.appendText("Garten-Daten");

		menu.addBrand(brand);
		menu.addToggleButton();

		Element collapse = menu.addCollapsible();
		Element main = menu.addSection(collapse);
		Element right = menu.addSectionRight(collapse);

		menu.addLink(main, "/gemüse", "Gemüse", false);
		menu.addLink(main, "/kompost", "Kompost", false);

		menu.addLink(right, "/", "Über", false);

		return menu;
	}

}
