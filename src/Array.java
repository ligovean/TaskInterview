public class Array{
    private int n ;
    private int[][] arr;

    public Array(int n) {
        this.n = n;
        this.arr= new int[n][n];
        fillLine2(n,1,new int[]{0,0});
    }

    public void printArr(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.format("%02d", arr[i][j])+" ");
            }
            System.out.printf("\n");
        }
    }

    //РЕКУРСИВНЫЙ МЕТОД ЗАПОЛНЕНИЯ СПИРАЛИ
    public int[] fillLine2(int demn,int loop,int[] res){
        int yLine = res[0];
        int xLine = res[1];
        int lastN;
        if (loop!=1)
            lastN = arr[yLine][xLine-1]+1;
        else
            lastN = 1;

        //Заполнение последнего элемента
        if (lastN>=demn*demn-1)
        {   if (demn%2!=0)
            {arr[yLine][xLine] = lastN;
            res[0]=yLine;
            res[1]=xLine;}
            else
            {res[0]=yLine;
            res[1]=xLine-1;}
            return res;}

        for (int tern=1;tern<5;tern++){
            for (int i=0; i<demn-((loop-1)*2+1); i++){
                switch (tern) {
                    case 1:
                        yLine = loop-1;
                        xLine = i+loop-1;
                        arr[yLine][xLine] = lastN;//[Y][X]
                        break;
                    case 2:
                        yLine = i+loop-1;
                        xLine = demn-loop;
                        arr[yLine][xLine] = lastN;//[Y][X]
                        break;
                    case 3:
                        yLine = demn-loop;
                        xLine = demn-loop-i;
                        arr[yLine][xLine] = lastN;//[Y][X]
                        break;
                    case 4:
                        yLine = demn-loop-i;
                        xLine = loop-1;
                        arr[yLine][xLine] = lastN;//[Y][X]
                        break;
                }
                lastN++;
            }
        }
        res[0]=yLine;
        res[1]=xLine+1;
        return fillLine2(demn,loop+1,res);
    }

}