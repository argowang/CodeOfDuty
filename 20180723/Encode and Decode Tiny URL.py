class Codec:
    def __init__(self):
        self.template = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        self.dic = {}
        self.key = self.getRand()
    
    def getRand(self):
        buf = []
        for i in range(6):
            buf.append(self.template[random.randint(0,61)])
        return "".join(buf)
    
    
    
    def encode(self, longUrl):
        """Encodes a URL to a shortened URL.
        
        :type longUrl: str
        :rtype: str
        """
        while self.key in self.dic:
            self.key = self.getRand()
        self.dic[self.key] = longUrl
        res = "".join(["http://tinyurl.com/"] + [self.key])
        return res

    def decode(self, shortUrl):
        """Decodes a shortened URL to its original URL.
        
        :type shortUrl: str
        :rtype: str
        """
    
        return self.dic[shortUrl.replace("http://tinyurl.com/", "")]
 
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(url))