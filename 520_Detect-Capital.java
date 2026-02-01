class Solution {
public:
    int count=0;
    bool detectCapitalUse(string word) {

            for(int i=0;i<word.length();i++){
                if(isupper(word[i])){
                    count++;
        
    }
            }

if(count==word.length() || count==0)
    return true;
    else if(count==1 && isupper(word[0]))
        return true;
    else{
        return false;
    }
    }

};