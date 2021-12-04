package com.example.mymate_test.data.member;

import com.example.mymate_test.data.member.model.DetailRequest;
import com.example.mymate_test.data.member.model.DetailResponse;
import com.example.mymate_test.data.member.model.GetRecommendMateListResponse;
import com.example.mymate_test.data.member.model.LoginRequest;
import com.example.mymate_test.data.member.model.LoginResponse;
import com.example.mymate_test.data.member.model.MyResponse;
import com.example.mymate_test.data.member.model.SignUpResponse;
import com.example.mymate_test.data.member.model.TypeRequest;
import com.example.mymate_test.data.member.model.TypeResponse;
import com.example.mymate_test.data.member.model.User;

/**
 * 모멘트립 데이터 레포지토리
 *
 * DataSource로 부터 Model을 가져오는 것을 추상화하는 역할
 */
public class Repository {
    private RemoteDataSource remoteDataSource = new RemoteDataSource();

    /** 회원가입 */
    public void createUser(User user, GetDataCallback<SignUpResponse> callback) {
        remoteDataSource.createUser(user, callback);
    }

    /** 로그인 */
    public void login(LoginRequest loginRequest, GetDataCallback<LoginResponse> callback) {
        remoteDataSource.login(loginRequest, callback);
    }

    public void createType(TypeRequest typeRequest, GetDataCallback<TypeResponse> callback){
        remoteDataSource.createType(typeRequest,callback);
    }

    public void getMy(Long id, GetDataCallback<MyResponse> callback){
        remoteDataSource.getMy(id,callback);
    }

    public void createDetail(DetailRequest detailRequest,GetDataCallback<Void> callback){
        remoteDataSource.createDetail(detailRequest,callback);
    }

    public void getDetail(Long id, GetDataCallback<DetailResponse> callback){
        remoteDataSource.getDetail(id,callback);
    }

    public void getRecommendMateList(Long memberId,String mateType1, GetDataCallback<GetRecommendMateListResponse> callback){
        remoteDataSource.getRecommendMateList(memberId,mateType1,callback);
    }

    /** 응답 콜백 */
    public interface GetDataCallback<T> {
        void onSuccess(T data);
        void onFailure(Throwable throwable);
    }
}
