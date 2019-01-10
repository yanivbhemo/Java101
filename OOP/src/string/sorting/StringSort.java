package string.sorting;

public class StringSort {
     public static void main(String args[])
        {
            String vec[] = {"abc", "aab", "aaa", "zxc", "cxs", "qwe", "gfd", "hjk", "asd"};
            String temp;

            for(int index=0; index<vec.length-1; index++)
            {
                for(int j=0;j<vec.length-1;j++) {
                    if (vec[j].compareTo(vec[j + 1]) < 0) {
                        temp = vec[j + 1];
                        vec[j + 1] = vec[j];
                        vec[j] = temp;
                    }
                }
            }

            for(int index=0; index<vec.length; index++)
            {
                System.out.println(vec[index]);
            }
        }
}
