class Solution {
       static Node rev(Node head){
        Node curr=head,prev=null,nxt=null;
        while(curr!=null){
            nxt = curr.next;
            curr.next=prev;
            prev=curr;
            curr=nxt;
        }
        return prev;
    }
    static int len(Node head){
        int temp = 0;
        while(head!=null){
            temp++;
            head=head.next;
        }
        return temp;
    }
    static int help(Node head1,Node head2){
        if(head1==null && head2==null)return 0;
        if(head1.data>head2.data)return 1;
        if(head1.data<head2.data)return 2;
        return help(head1.next,head2.next);
    }
    public Node subLinkedList(Node head1, Node head2) {
        // code here
        Node ans=new Node(0);
        while(head1!=null && head1.data==0)head1=head1.next;
        while(head2!=null && head2.data==0)head2=head2.next;
        if(head1==null && head2==null)return ans;
        if(head1==null)return head2;
        if(head2==null)return head1;
        Node greater=head1,less=head2;
        int len1 = len(head1);
        int len2 = len(head2);
        if(len2>len1){
            greater=head2;
            less=head1;
        }
        else if(len2==len1){
            if(help(head1,head2)==2){
                greater=head2;
                less=head1;
            }
            else if(help(head1,head2)==0){
                return ans;
            }
        }
        Node temp=ans;
        greater = rev(greater);
        less = rev(less);
        while(less!=null){
            if(greater.data>=less.data){
                temp.next=new Node(greater.data-less.data);
            }
            else{
                temp.next=new Node(greater.data+10-less.data);
                Node nxt = greater.next;
                if(nxt.data!=0)nxt.data=nxt.data-1;
                else{
                    while(nxt.data==0){
                        nxt.data=9;
                        nxt=nxt.next;
                    }
                    nxt.data=nxt.data-1;
                }
            }
            greater=greater.next;
            less=less.next;
            temp=temp.next;
        }
        while(greater!=null){
            temp.next=new Node(greater.data);
            greater=greater.next;
            temp=temp.next;
        }
        ans=rev(ans.next);
        while(ans!=null && ans.data==0)ans=ans.next;
        return ans;
    }
}
