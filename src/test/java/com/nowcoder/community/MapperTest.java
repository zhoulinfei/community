package com.nowcoder.community;


import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(1);
        System.out.println(user);

        user = userMapper.selectByName("test");
        System.out.println(user);

        user = userMapper.selectByEmail("test@qq.com");
        System.out.println(user);
    }


//    @Test
//    public void testInsertUser() {
//        User user = new User();
//        user.setUsername("test");
//        user.setPassword("123456");
//        user.setSalt("abc");
//        user.setEmail("test@qq.com");
//        user.setHeaderUrl("http://www.nowcoder.com/101.png");
//        user.setCreateTime(new Date());
//
//        int rows = userMapper.insertUser(user);
//        System.out.println(rows);
//        System.out.println(user.getId());
//    }

    @Test
    public void testSelectPosts() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPost(103, 0, 10);
        for (DiscussPost discussPost : list) {
            System.out.println(discussPost);
        }

        int rows  =  discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);
    }


}
