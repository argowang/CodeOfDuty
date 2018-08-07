# Not difficult but too many cases need to be considered....
# Please practice it more than one time..
class Solution(object):
    def __init__(self):
        self.LESS_THAN_TWENTY = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen","Seventeen", "Eighteen", "Nineteen"]
        self.TENS = ["","","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Hundred"]
        self.THOUSANDS = ["","Thousand","Million", "Billion"]
    
    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        if num == 0:
            return "Zero"
        word = ""
        i = 0
        while num > 0:
            if num % 1000 != 0:
                word = self.helpers(num % 1000) + self.THOUSANDS[i] + " " + word
            num /= 1000
            i += 1
        return word.strip()
            
            
    def helpers(self, num):
        if num == 0:
            return ""
        elif num < 20:
            return self.LESS_THAN_TWENTY[num] + " "
        elif num < 100:
            return self.TENS[num / 10] + " "+ self.helpers(num % 10)
        else:
            return self.LESS_THAN_TWENTY[num / 100] + " Hundred " + self.helpers(num % 100)
        
        