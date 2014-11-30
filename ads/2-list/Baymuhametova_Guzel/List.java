class List
{
///////////////////////////////////////////////////////////////////////
   public List()//конструктор для создания пустого списка
   {   
       this.headNode = null;
       this.tailNode = this.headNode;
       this.Length = 0;
   }
///////////////////////////////////////////////////////////////////////
   public void Push(Polimonchick elem)
        {
            if (headNode == null)
            {
                this.headNode = new Node();// создать узел, сделать его головным
                this.headNode.element =elem;
                this.tailNode = this.headNode;  // этот же узел и является хвостом
                this.headNode.setNext(null);// следующего узла нет
            }
            else
            {
                Node newNode = new Node();
                this.tailNode.setNext(newNode);
                this.tailNode = newNode;
                this.tailNode.element =elem;
                this.tailNode.setNext(null);
            }
 
            ++this.Length;
        }
//////////////////////////////////////////////////////////////////////////////////////
        public Polimonchick getForIndex (int p)
        {
                Node tempNode = this.headNode;
                for (int i = 0; i<p; i++)
                tempNode = tempNode.getNext();
                return tempNode.element;
            
        }
//////////////////////////////////////////////////////////////////////////        
        public void DeleteIndex (int p)
        {
            if (p==0)
            {
            	Node New=new Node();
            	New=headNode;
            	headNode=headNode.getNext();
            	New=null;
            	-- this.Length;
            	return;
            }
            if (p==Length-1)
            { 
            	Node New=new Node();
            	New=headNode;
            	for(int i=0;i<Length-2;i++)
            	{
            		New=New.getNext();
                }
            	tailNode=New;
            	New=New.getNext();
            	New=null;
            	-- this.Length;
            	return;
           }
            if (p!=Length&&p!=0)
            {
            	Node New=new Node();
            	New=headNode;
            	for(int i = 0;i<p-1;i++)
            	{
            		New=New.getNext();
            	}
                Node New2=new Node();
                New2=New.getNext();
                New.setNext(New.getNext().getNext());
                New2=null;
                Length--;	
            }
            }
/////////////////////////////////////////////////////////////////////////////////////      
        public void DeleteNulei()
        {
        	for(int i = 0;i<Length;i++)
        	{
        		Polimonchick p=new Polimonchick();
        		p=getForIndex(i);
        		if (p.step==0) DeleteIndex(i);
        	}
        }
 ////////////////////////////////////////////////////////////////////////////////////
        public void Podobie()
        {
        	for(int i = 0;i<Length;i++)
        	{
               int j=i+1;
               while (j<Length)
               {
                   if(getForIndex(i).power == getForIndex(j).power)
                   {
                       getForIndex(i).step+=getForIndex(j).step;
                       DeleteIndex(j);
                   }
                   else
                       j++;
               }
        	}
        }
//////////////////////////////////////////////////////////////////////////////
        public  void show()
        {
            System.out.println("");

            for(int i = 0;i<Length;i++)
            {
                System.out.print(getForIndex(i).step + "X^" + getForIndex(i).power + " + ");
                
            }

            System.out.println("");
        }
        public int Length ;
        private Node headNode;
        private Node tailNode;
    }