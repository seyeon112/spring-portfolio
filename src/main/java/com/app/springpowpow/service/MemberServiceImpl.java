package com.app.springpowpow.service;

import com.app.springpowpow.domain.MemberVO;
import com.app.springpowpow.repository.CartDAO;
import com.app.springpowpow.repository.MemberDAO;
import com.app.springpowpow.repository.PetDAO;
import com.app.springpowpow.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;
    private final PetDAO petDAO;
    private final CartDAO cartDAO;
    private final PostDAO postDAO;

    @Override
    public Optional<MemberVO> getMemberById(Long id) {
        return memberDAO.findById(id);
    }



    @Override
    public List<MemberVO> getAllMembers() {
        return memberDAO.findAll();
    }

    @Override
    public Long getMemberIdByEmail(String memberEmail) {
        return memberDAO.findByEmail(memberEmail);
    }

    @Override
    public void register(MemberVO memberVO) {
        memberDAO.save(memberVO);
    }

    @Override
    public void modify(MemberVO memberVO) {
        memberDAO.update(memberVO);
    }

    @Override
    public void withdraw(Long id) {
        postDAO.removeAll(id);
        petDAO.deleteAll(id);
        cartDAO.removeMember(id);
        memberDAO.delete(id);
    }

    @Override
    public boolean checkDuplicate(String memberEmail) {
        int count = memberDAO.checkDuplicate(memberEmail);

        return count > 0;
    }

    //    판매자 회원탈퇴
    @Override
    public void withdrawSeller(Long id) {

        memberDAO.delete(id);
    }

    // 전화번호로 이메일 찾기
    @Override
    public String findEmail(String memberPhone) {
        return memberDAO.findEmail(memberPhone);
    }

    // 이메일로 회원 정보 조회
    @Override
    public Optional<MemberVO> findMember(String memberEmail) {
        return memberDAO.findMember(memberEmail);
    }
}

