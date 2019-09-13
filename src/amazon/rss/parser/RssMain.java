package amazon.rss.parser;

public class RssMain {

	public static void main(String[] args) throws Exception {
		// Ex:https://www.amazon.in/gp/rss/bestsellers/grocery/4860245031/ref=zg_bs_4860245031_rsslink
		RSSFeedParser parser = new RSSFeedParser("Enter amazon URL here");
		Feed feed = parser.readFeed();
		for (FeedMessage message : feed.getMessages()) {

			System.out.println(message);
		}

	}

}
