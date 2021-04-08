/*
 * @lc app=leetcode id=1797 lang=java
 *
 * [1797] Design Authentication Manager
 */

// @lc code=start
class AuthenticationManager {

    PriorityQueue<Token> heap;
    Map<String, Token> map;
    int timeToLive;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.heap = new PriorityQueue<>(new Comparator<Token>(){
            public int compare(Token a, Token b) {
                if (a.expiry == b.expiry) {
                    return a.id.compareTo(b.id);
                }
                return a.expiry - b.expiry;
            }
        });
        this.map = new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
        Token token = new Token(tokenId, currentTime + timeToLive);
        map.put(tokenId, token);
        heap.add(token);
    }
    
    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId) && map.get(tokenId).expiry > currentTime) {
            Token token = map.get(tokenId);
            heap.remove(token);
            token.expiry = currentTime + timeToLive;
            heap.add(token);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        while (heap.size() > 0 && heap.peek().expiry <= currentTime) {
            heap.poll();
        }

        return heap.size();
    }

    class Token {
        String id;
        int expiry;
        public Token(String id, int expiry) {
            this.id = id;
            this.expiry = expiry;
        }
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */
// @lc code=end

