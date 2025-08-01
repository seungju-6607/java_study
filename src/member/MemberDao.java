package member;

import java.util.ArrayList;
import java.util.List;
import db.DBConn;

public class MemberDao extends DBConn implements MemberInterface {

    public MemberDao() {
        super();  // DB 연결 (DBConn 상속)
    }

    /**
     * 회원 등록
     */
    @Override
    public int insert(MemberVo memberVo) {
        int rows = 0;
        String sql = """
            insert into member (name, email) values (?, ?)
        """;

        try {
            getPreparedStatement(sql);
            pstmt.setString(1, memberVo.getName());
            pstmt.setString(2, memberVo.getEmail());
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows;
    }


    /**
     * 회원 전체 조회
     */
    @Override
    public List<MemberVo> listAll() {
        List<MemberVo> list = new ArrayList<>();
        String sql = "select member_id, name, email, created_at from member";

        try {
            getPreparedStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                MemberVo vo = new MemberVo();
                vo.setMemberId(rs.getInt(1));
                vo.setName(rs.getString(2));
                vo.setEmail(rs.getString(3));
                vo.setCreatedAt(rs.getString(4));
                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public MemberVo search(int memberId) {
        MemberVo member = new MemberVo();
        String sql = """
            select member_id, name, email, created_at 
            from member 
            where member_id = ?
            """;

        try {
            getPreparedStatement(sql);
            pstmt.setInt(1, memberId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                member.setMemberId(rs.getInt("member_id"));
                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));
                member.setCreatedAt(rs.getString("created_at"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return member;
    }

    /**
     * 이름으로 검색
     */
    @Override
    public List<MemberVo> search(String name) {
        List<MemberVo> list = new ArrayList<>();
        String sql = """
            select member_id, name, email, created_at 
            from member 
            where name = ?
            """;

        try {
            getPreparedStatement(sql);
            pstmt.setString(1, name);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                MemberVo vo = new MemberVo();
                vo.setMemberId(rs.getInt("member_id"));
                vo.setName(rs.getString("name"));
                vo.setEmail(rs.getString("email"));
                vo.setCreatedAt(rs.getString("created_at"));
                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 회원 정보 수정
     */
    @Override
    public int update(MemberVo memberVo) {
        int rows = 0;
        String sql = """
            update member 
            set name = ?, email = ? 
            where member_id = ?
            """;

        try {
            getPreparedStatement(sql);
            pstmt.setString(1, memberVo.getName());
            pstmt.setString(2, memberVo.getEmail());
            pstmt.setInt(3, memberVo.getMemberId());
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rows;
    }

    /**
     * 회원 삭제
     */
    @Override
    public int delete(int memberId) {
        int rows = 0;
        String sql = "delete from member where member_id = ?";

        try {
            getPreparedStatement(sql);
            pstmt.setInt(1, memberId);
            rows = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rows;
    }
}
