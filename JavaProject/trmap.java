class trmap
{
    String secFrequent(String arr[], int N)
    {
        // your code here
        TreeMap<String,Integer>map = new TreeMap<String,Integer>(Collections.reverseOrder());
        int count=0;
        for(int i=0;i<N;i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        
        for(Map.Entry m:map.entrySet())
        {   
           count++;
           if(count==2)
            return (String) m.getKey();
        }
        return "";
    }
}