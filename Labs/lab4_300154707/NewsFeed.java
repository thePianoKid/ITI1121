/* *
 * Use static array for NewsFeed
 * with constant MAX_SIZE
 * */

public class NewsFeed {

    private Post[] messages;
    private int size;
    public static final int MAX_SIZE = 25;

	// ------------------------- Helper Methods -------------------------
	private int measureSizeOfMessage(Post[] messages) {
		int arrSize = 0;

		for(int i = 0; i < messages.length; i++) {
			if (messages[i] != null) {
				arrSize++;
			}
		}

		return arrSize;
	}

    public NewsFeed() {
    	this.size = 0;
		this.messages = new Post[MAX_SIZE];
    }

    public void add(Post message) {
      if (size() < MAX_SIZE) {
		this.messages[size()] = message;
	  }
    }

    public Post get(int index) {
	     return messages[index];
    }

    public int size() {
		size = measureSizeOfMessage(messages);
		return size;
    }

	public void sort(){
		int i, j, argMin;
		Post tmp;
		for (i = 0; i < size - 1; i++) {
			argMin = i;
			for (j = i + 1; j < size(); j++) {
				if (messages[j].compareTo(messages[argMin]) < 0) {
					argMin = j;
				}
			}

		tmp = messages[argMin];
		messages[argMin] = messages[i];
		messages[i] = tmp;
		}

	}

  	public NewsFeed getPhotoPost(){
		NewsFeed rtnFeed = new NewsFeed();

		for (Post p : messages) {
			if (p != null) {
				if (p.getClass() == PhotoPost.class) {
					rtnFeed.add(p);
				}
			}
		}
		
		return rtnFeed;
  	}

  	public NewsFeed plus(NewsFeed other){
		NewsFeed rtnFeed = new NewsFeed();

		if ((this.size + other.size) <= MAX_SIZE) {
			for (Post p : this.messages) {
				rtnFeed.add(p);
			}

			for (Post p : other.messages) {
				rtnFeed.add(p);
			}
		} 

		return rtnFeed;
  	}
}
