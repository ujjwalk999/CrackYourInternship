

class Solution
{
    //Function to find the largest number after k swaps.
    static String max;
    public static String findMaximumNum(String str, int k)
    {
        max = str;  // Initialize max with the original string
        findMaximumNumHelper(str.toCharArray(), k);
        return max;
    }
        private static void findMaximumNumHelper(char[] s, int k) {
        
           if(k==0)
           {
               return ;
               
           }
           int n=s.length;
           for(int i=0;i<n;i++)
           {
               for(int j=i+1;j<n;j++)
               {
                   if(s[i]<s[j])
                   {
                       char temp=s[i];
                       s[i]=s[j];
                       s[j]=temp;
                     String current = new String(s);
                      if (current.compareTo(max) > 0) {
                        max = current;
                       }
                        findMaximumNumHelper(s, k - 1);
                        char c=s[i];
                        s[i]=s[j];
                        s[j]=c;
                   }
               }
           }
        } 
        
}
