package com.siberiadante.custom.bean;

import java.util.List;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/8/29
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class NewsData {

    /**
     * id : 2114
     * uid : 1
     * title : 为什么日本员工看上去都很负责？
     * description : 　看过电影，电视中日本的下属对待上司毕恭毕敬，对待工作认真负责，一丝不苟，也不会主动要求增加待遇，极具工匠精神，引来国内的赞叹和羡慕，希望学习日本员工的工匠精神，但是学到者和改变者寥寥，根源是只看到日本人工作时表层的持之以恒，根植于日本文化下的社会规则却被忽视。　　日本的上司对下属必须持有&quot;爱&quot;，下属对上司必须持有&quot;恩&quot;。　　上司要庇护下属的成长，甚至下属是
     * category : 2
     * status : 1
     * reason :
     * sort : 0
     * position : 0
     * cover : 0
     * view : 4
     * comment : 0
     * collection : 0
     * dead_line : 2038-01-19 11:14
     * source : http://dy.163.com/v2/article/detail/CRTV0EMD05218341.html
     * create_time : 8分钟前
     * post_time : 0
     * update_time : 6分钟前
     * thumb : ["http://oss.chinichi.cn/images/59a4c8df3879f.png"]
     * favorite : 0
     * recommend : 1
     * author : 这才是日本
     * cover_url :
     * approval : 未过期
     * share_url : http://www.chinichi.cn/index.php?s=/news/index/detail/id/2114.html
     * user : {"uid":"1","nickname":"kumotobi","signature":"这家伙很懒,什么都没有留下。","score1":"77","real_nickname":"kumotobi","title":"Lv2 路旁的落叶","avatar32":"http://www.chinichi.cn/Uploads/Avatar/1/58b28470a0011.jpg","avatar64":"http://www.chinichi.cn/Uploads/Avatar/1/58b28470a0011.jpg","avatar128":"http://www.chinichi.cn/Uploads/Avatar/1/58b28470a0011.jpg","avatar256":"http://www.chinichi.cn/Uploads/Avatar/1/58b28470a0011.jpg","avatar512":"http://www.chinichi.cn/Uploads/Avatar/1/58b28470a0011.jpg"}
     * category_title : 观察
     */

    private String id;
    private String uid;
    private String title;
    private String description;
    private String category;
    private String status;
    private String reason;
    private String sort;
    private String position;
    private String cover;
    private String view;
    private String comment;
    private String collection;
    private String dead_line;
    private String source;
    private String create_time;
    private String post_time;
    private String update_time;
    private String favorite;
    private String recommend;
    private String author;
    private String cover_url;
    private String approval;
    private String share_url;
    private UserBean user;
    private String category_title;
    private List<String> thumb;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getDead_line() {
        return dead_line;
    }

    public void setDead_line(String dead_line) {
        this.dead_line = dead_line;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getPost_time() {
        return post_time;
    }

    public void setPost_time(String post_time) {
        this.post_time = post_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover_url() {
        return cover_url;
    }

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    public String getShare_url() {
        return share_url;
    }

    public void setShare_url(String share_url) {
        this.share_url = share_url;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getCategory_title() {
        return category_title;
    }

    public void setCategory_title(String category_title) {
        this.category_title = category_title;
    }

    public List<String> getThumb() {
        return thumb;
    }

    public void setThumb(List<String> thumb) {
        this.thumb = thumb;
    }

    public static class UserBean {
        /**
         * uid : 1
         * nickname : kumotobi
         * signature : 这家伙很懒,什么都没有留下。
         * score1 : 77
         * real_nickname : kumotobi
         * title : Lv2 路旁的落叶
         * avatar32 : http://www.chinichi.cn/Uploads/Avatar/1/58b28470a0011.jpg
         * avatar64 : http://www.chinichi.cn/Uploads/Avatar/1/58b28470a0011.jpg
         * avatar128 : http://www.chinichi.cn/Uploads/Avatar/1/58b28470a0011.jpg
         * avatar256 : http://www.chinichi.cn/Uploads/Avatar/1/58b28470a0011.jpg
         * avatar512 : http://www.chinichi.cn/Uploads/Avatar/1/58b28470a0011.jpg
         */

        private String uid;
        private String nickname;
        private String signature;
        private String score1;
        private String real_nickname;
        private String title;
        private String avatar32;
        private String avatar64;
        private String avatar128;
        private String avatar256;
        private String avatar512;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getScore1() {
            return score1;
        }

        public void setScore1(String score1) {
            this.score1 = score1;
        }

        public String getReal_nickname() {
            return real_nickname;
        }

        public void setReal_nickname(String real_nickname) {
            this.real_nickname = real_nickname;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAvatar32() {
            return avatar32;
        }

        public void setAvatar32(String avatar32) {
            this.avatar32 = avatar32;
        }

        public String getAvatar64() {
            return avatar64;
        }

        public void setAvatar64(String avatar64) {
            this.avatar64 = avatar64;
        }

        public String getAvatar128() {
            return avatar128;
        }

        public void setAvatar128(String avatar128) {
            this.avatar128 = avatar128;
        }

        public String getAvatar256() {
            return avatar256;
        }

        public void setAvatar256(String avatar256) {
            this.avatar256 = avatar256;
        }

        public String getAvatar512() {
            return avatar512;
        }

        public void setAvatar512(String avatar512) {
            this.avatar512 = avatar512;
        }
    }
}
