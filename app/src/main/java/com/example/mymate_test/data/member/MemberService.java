package com.example.mymate_test.data.member;

import com.example.mymate_test.data.member.model.DetailRequest;
import com.example.mymate_test.data.member.model.DetailResponse;
import com.example.mymate_test.data.member.model.GetRecommendMateListResponse;
import com.example.mymate_test.data.member.model.LoginRequest;
import com.example.mymate_test.data.member.model.LoginResponse;
import com.example.mymate_test.data.member.model.SignUpResponse;
import com.example.mymate_test.data.member.model.TypeRequest;
import com.example.mymate_test.data.member.model.TypeResponse;
import com.example.mymate_test.data.member.model.MyResponse;
import com.example.mymate_test.data.member.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MemberService { // 네트워크 통신(Retrofit2)를 위한 API 명세
    /**
     * SignUp
     */
    @POST("member/signUp")
    Call<SignUpResponse> createUser(@Body User user);

    /**
     * Login
     */
    @POST("member/login")
    Call<LoginResponse> login(@Body LoginRequest loginRequest);

    /**
     * Type
     */
    @POST("member/type")
    Call<TypeResponse> createType(@Body TypeRequest typeRequest);
    /**
     * my data
     */
    @GET("member/my/{id}")
     Call<MyResponse> getMy(@Path("id") Long id);


    /**
     * detail
     */
    @POST("member/detail")
    Call<Void> createDetail(@Body DetailRequest detailRequest);

    @GET("member/detail/{id}")
    Call<DetailResponse> getDetail(@Path("id") Long id);

//

    @GET("member/recommend/{memberId}/{mateType1}")
    Call<GetRecommendMateListResponse> getRecommendMateList(@Path("memberId") Long memberId,@Path("mateType1") String mateType1);

}

