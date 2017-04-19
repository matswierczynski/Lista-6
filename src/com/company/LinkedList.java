package com.company;


/**
 * Created by Mati on 2017-04-17.
 */
public class LinkedList<E> implements LinkedListInterface<E> {
    private final Element _headAndTail = new Element();
    private final int size;
    private final Matrix matrix;

    public LinkedList(LinkedList<E> lList)
    {
        size = lList.getSize();
        matrix=null;
        createEmpty();
    }
    public LinkedList(int _size){
        size=_size;
        matrix = new Matrix(size);
        createEmpty();
        createLinkedMatrix();

    }

    public LinkedList(LinkedList<E> lList, LinkedList<E> lList1){
        matrix=null;
        size=lList.matrix.getMatrix().length;
        createEmpty();
        for(int i=1;i<=size;i++)
            for(int k=1;k<=size;k++)
                set(i,k,lList.get(i,k)+lList1.get(i,k));
    }



    private void createEmpty(){
        Element current=_headAndTail;
        for (int i=0; i<=size;i++){
            Element el = new Element(0,0,i);
            current.attachInRow(el);
            current=current.getNextRow();
        }

        current=_headAndTail;
        for (int i=0; i<=size;i++){
            Element el = new Element(0,i,0);
            current.attachInCol(el);
            current=current.getNextCol();
        }


    }



    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean isEmpty() {
       return size<=0;
    }

    @Override
    public int getSize() {
        return size;
    }



    @Override
    public void set(int row, int col, int o)
            throws IndexOutOfBoundsException {
        if (row > size || col > size || row < 1 || col < 1) throw new IndexOutOfBoundsException();
        if ( o != 0) {
            Element newElement = new Element(o, col, row);
            Element _row = _headAndTail;
            Element _col = _headAndTail;

            while (_row.getNextCol() != null && _row.getColNr() != col)  //odpowiednia kolumna w wierszu 0
                _row = _row.getNextCol();

            if (_row.getNextRow() != null) {
                while (_row.getNextRow().getNextRow() != null && _row.getNextRow().getNextRow().getRowNr() <= row)
                    _row = _row.getNextRow();

                if (_row.getNextRow().getRowNr() == row) {
                    _row.getNextRow().setKey(o);

                }
                else {
                    _row.attachInRow(newElement);
                }
            }
            else
                _row.attachInRow(newElement);


            while (_col.getNextRow() != null && _col.getRowNr() != row)  //odpowiedni wiersz w kolumnie 0
                _col = _col.getNextRow();

            if (_col.getNextCol() != null) {
                    while (_col.getNextCol() != null && _col.getNextCol().getColNr() <= col)
                        _col = _col.getNextCol();

                }
                _col.attachInCol(newElement);

        }
    }


    @Override
    public int get(int row, int col) throws IndexOutOfBoundsException {

        if (row > size || col > size || row < 1 || col < 1) throw new IndexOutOfBoundsException();

            Element _row = _headAndTail;

            while (_row.getNextCol() != null && _row.getColNr() != col)  //odpowiednia kolumna w wierszu 0
                _row = _row.getNextCol();

            if (_row.getNextRow() != null) {
                while (_row.getNextRow() != null && _row.getRowNr() != row)
                    _row = _row.getNextRow();
            }

            if (_row.getColNr()==col && _row.getRowNr() == row)
                return _row.getKey();
            else return 0;

        }

    public void show() {
        Element curRow=_headAndTail;
        Element curCol;
        while (curRow.getNextRow() != null) {
            curRow = curRow.getNextRow();
            curCol = curRow;
            while (curCol.getNextCol() != null) {
                curCol = curCol.getNextCol();
                System.out.print(curCol.getRowNr()+""+curCol.getColNr()+" " + curCol.getKey() + "    ");
            }
            System.out.println();
        }
    }

    public void showFormatted() {
        System.out.println("-------------------------");
        for(int i=1;i<=size;i++) {
            for (int k = 1; k <= size; k++)
                System.out.print(" " + get(i, k));
            System.out.println();
        }
        System.out.println("-------------------------");
        }




    public void createLinkedMatrix(){
        int [][] _matrix=matrix.getMatrix();
        for(int i=1;i<=_matrix.length;i++)
            for(int k=1;k<=_matrix[i-1].length;k++)
                set(i,k,_matrix[i-1][k-1]);
    }

    public static int collectSize(String message){
        int size=0;
        int [] _size;
        while(size<=0){
            System.out.println(message);
            _size=Matrix.loadData(1);
            size=_size[0];
        }

        return size;
    }

    public static LinkedList ScalarMultiplication(LinkedList<Integer> lList){
        int scalar = collectSize("Podaj mnożnik");
         LinkedList<Integer> multipledList = new LinkedList<>(lList);
        for(int i=1;i<=lList.getSize();i++)
            for(int k=1;k<=lList.getSize();k++)
                multipledList.set(i,k,lList.get(i,k)*scalar);
        return multipledList;
    }


    private final class Element{
        private int rowNr;
        private int colNr;
        private int key;
        private Element nextRow;
        private Element nextCol;

        public Element (int nr, int col, int row){
            this.rowNr=row;
            this.colNr=col;
            this.key = nr;
        }

        public Element() {
            this(0,0,0);
            this.nextRow = null;
            this.nextCol = null;

        }

        private void attachInRow(Element e) throws NullPointerException
        {
            if (e==null) throw new NullPointerException();
            e.setNextRow(this.getNextRow());
            this.setNextRow(e);
        }

        private void attachInCol(Element e) throws NullPointerException
        {
            if (e==null) throw new NullPointerException();
            e.setNextCol(this.getNextCol());
            this.setNextCol(e);
        }


        private void detachInRow ()
        {
            Element element=getNextRow().getNextRow();
            setNextRow(element);
        }

        private void detachInCol ()
        {
            Element element=getNextCol().getNextCol();
            setNextCol(element);
        }

        private void setNextRow(Element next) {
            this.nextRow = next;
        }

        private void setNextCol(Element next) {this.nextCol = next; }

        private void setColNr(int next) {this.colNr = next; }

        private void setRowNr(int next) {this.rowNr = next; }

        private void setKey(int key) {
            this.key = key;
        }

        private Element getNextRow() { return nextRow;}

        private Element getNextCol() { return nextCol;}

        private int getColNr() { return colNr;}

        private int getRowNr() { return rowNr;}

        private int getKey() {
            return key;
        }

        @Override
        public String toString(){ return Integer.toString(key);}



    }
}
