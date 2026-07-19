class Twitter {

    HashMap<Integer, Set<Integer>> follow;
    HashMap<Integer, Tweet> tweets;
    int timestamp = 0;

    class Tweet {
        int tweetId;
        int time;
        Tweet next;

        public Tweet(int tweetId) {
            this.tweetId = tweetId;
            this.time = timestamp++;
        }
    }

    public Twitter() {
        follow = new HashMap<>();
        tweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        Tweet post = new Tweet(tweetId);
        post.next = tweets.get(userId);
        tweets.put(userId, post);
    }

    public List<Integer> getNewsFeed(int userId) {

        // Ensure the user follows themselves
        follow(userId, userId);

        List<Integer> ans = new ArrayList<>();

        PriorityQueue<Tweet> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.time, a.time)
        );

        // Add the newest tweet of every followed user
        for (int followee : follow.get(userId)) {
            Tweet head = tweets.get(followee);
            if (head != null) {
                pq.offer(head);
            }
        }

        // Get the 10 most recent tweets
        while (!pq.isEmpty() && ans.size() < 10) {
            Tweet curr = pq.poll();
            ans.add(curr.tweetId);

            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {

        if (!follow.containsKey(followerId)) {
            follow.put(followerId, new HashSet<>());
        }

        follow.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        // User should never unfollow themselves
        if (followerId == followeeId) {
            return;
        }

        if (follow.containsKey(followerId)) {
            follow.get(followerId).remove(followeeId);
        }
    }
}