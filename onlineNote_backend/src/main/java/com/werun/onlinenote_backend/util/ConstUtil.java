package com.werun.onlinenote_backend.util;
/**
 * @ClassName ConstUtil
 * @Description 工具层
 * @Author honghaitao
 * @Updater liuzijun
 * @Create 2022-03-24
 * @Update 2022-03-31
 **/
public class ConstUtil {
    //================================================================================
    //登录相关
    public static final String LOGIN = "/login";
    public static final String REGISTER = "/register";
    public static final String OTHERS = "/**";

    //================================================================================
    //Category 相关
    public static final String ADD_CATEGORY = "/category/addCategory";
    public static final String DELETE_CATEGORY = "/category/deleteCategory";
    public static final String GET_CATEGORY = "/category/getCategory";
    public static final String CHANGE_CATEGORY_NAME = "/category/changeCategoryName";

    //================================================================================
    //Note 相关
    public static final String ADD_NOTE = "/note/addNote";
    public static final String DELETE_NOTE = "/note/deleteNote";
    public static final String GET_NOTE = "/note/getNote";
    public static final String CHANGE_NOTE_TITLE = "/note/changeNoteTitle";
    public static final String CHANGE_NOTE_CATEGORY = "/note/changeNoteCategory";
    public static final String CHANGE_NOTE_COMPLETED_STATE = "/note/changeNoteCompletedState";
    public static final String CHANGE_NOTE_CONTENT = "/note/changeNoteContent";

    //================================================================================
    //User 相关
    public static final String ADD_USER = "/user/addUser";
    public static final String DELETE_USER = "/user/deleteUser";
    public static final String GET_USER = "/user/getUser";
    public static final String CHANGE_USER_NAME = "/user/changeUser";

}
