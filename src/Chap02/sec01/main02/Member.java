package Chap02.sec01.main02;

public class Member implements Cloneable {

    private String memberId;
    private String memberName;

    public Member(String memberId, String memberName) {
        super();
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public String toString() {
        return "[" + memberId + "," + memberName + "]";
    }

    @Override
    protected Member clone() throws CloneNotSupportedException {
        Member clonedMember = (Member) super.clone();

        return clonedMember;
    }
}
