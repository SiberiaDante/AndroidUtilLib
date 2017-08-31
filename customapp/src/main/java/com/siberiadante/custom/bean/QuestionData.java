package com.siberiadante.custom.bean;

import java.util.List;

/**
 * @Created SiberiaDante
 * @Describe：
 * @Time: 2017/8/7
 * @Email: 994537867@qq.com
 * @GitHub: https://github.com/SiberiaDante
 */

public class QuestionData {
    /**
     * id : 25
     * uid : 1284
     * category : 1
     * title : 安倍首相
     * description : 安倍首相到底会不会下台？修宪大业能成功吗
     * answer_num : 2
     * best_answer : 0
     * good_question : 0
     * status : 1
     * is_recommend : 0
     * create_time : 1497855658
     * update_time : 1499851369
     * leixing : 1
     * score_num : 0
     * attach_ids : 351
     * user : {"uid":"1284","nickname":"はつこい","signature":"这家伙很懒,什么都没有留下。","score1":"5","real_nickname":"はつこい","title":"Lv1 无名的旅人","avatar32":"http://www.chinichi.cn/Uploads/Avatar/1284/5947717de171e.jpeg","avatar64":"http://www.chinichi.cn/Uploads/Avatar/1284/5947717de171e.jpeg","avatar128":"http://www.chinichi.cn/Uploads/Avatar/1284/5947717de171e.jpeg","avatar256":"http://www.chinichi.cn/Uploads/Avatar/1284/5947717de171e.jpeg","avatar512":"http://www.chinichi.cn/Uploads/Avatar/1284/5947717de171e.jpeg"}
     * thumb_count : 1
     * thumb : ["http://www.chinichi.cn/Uploads/Picture/2017-07-12/5965ea68ade33_200_200.jpg"]
     */

    private String id;
    private String uid;
    private String category;
    private String title;
    private String description;
    private String answer_num;
    private String best_answer;
    private String good_question;
    private String status;
    private String is_recommend;
    private String create_time;
    private String update_time;
    private String leixing;
    private String score_num;
    private String attach_ids;
    private UserBean user;
    private int thumb_count;
    private List<String> thumb;

    @Override
    public String toString() {
        return "QuestionData{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", category='" + category + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", answer_num='" + answer_num + '\'' +
                ", best_answer='" + best_answer + '\'' +
                ", good_question='" + good_question + '\'' +
                ", status='" + status + '\'' +
                ", is_recommend='" + is_recommend + '\'' +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", leixing='" + leixing + '\'' +
                ", score_num='" + score_num + '\'' +
                ", attach_ids='" + attach_ids + '\'' +
                ", user=" + user +
                ", thumb_count=" + thumb_count +
                ", thumb=" + thumb +
                '}';
    }

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getAnswer_num() {
        return answer_num;
    }

    public void setAnswer_num(String answer_num) {
        this.answer_num = answer_num;
    }

    public String getBest_answer() {
        return best_answer;
    }

    public void setBest_answer(String best_answer) {
        this.best_answer = best_answer;
    }

    public String getGood_question() {
        return good_question;
    }

    public void setGood_question(String good_question) {
        this.good_question = good_question;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIs_recommend() {
        return is_recommend;
    }

    public void setIs_recommend(String is_recommend) {
        this.is_recommend = is_recommend;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getLeixing() {
        return leixing;
    }

    public void setLeixing(String leixing) {
        this.leixing = leixing;
    }

    public String getScore_num() {
        return score_num;
    }

    public void setScore_num(String score_num) {
        this.score_num = score_num;
    }

    public String getAttach_ids() {
        return attach_ids;
    }

    public void setAttach_ids(String attach_ids) {
        this.attach_ids = attach_ids;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public int getThumb_count() {
        return thumb_count;
    }

    public void setThumb_count(int thumb_count) {
        this.thumb_count = thumb_count;
    }

    public List<String> getThumb() {
        return thumb;
    }

    public void setThumb(List<String> thumb) {
        this.thumb = thumb;
    }

    public static class UserBean {
        /**
         * uid : 1284
         * nickname : はつこい
         * signature : 这家伙很懒,什么都没有留下。
         * score1 : 5
         * real_nickname : はつこい
         * title : Lv1 无名的旅人
         * avatar32 : http://www.chinichi.cn/Uploads/Avatar/1284/5947717de171e.jpeg
         * avatar64 : http://www.chinichi.cn/Uploads/Avatar/1284/5947717de171e.jpeg
         * avatar128 : http://www.chinichi.cn/Uploads/Avatar/1284/5947717de171e.jpeg
         * avatar256 : http://www.chinichi.cn/Uploads/Avatar/1284/5947717de171e.jpeg
         * avatar512 : http://www.chinichi.cn/Uploads/Avatar/1284/5947717de171e.jpeg
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
