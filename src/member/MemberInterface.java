package member;

import java.util.List;

public interface MemberInterface<T> {
	public List<MemberVo> search(String name);
	public MemberVo search(int memberId);
	public int delete(int memberId);
	public int update(MemberVo membervo);
	public List<MemberVo> listAll();
	public int insert(MemberVo membervo);
}