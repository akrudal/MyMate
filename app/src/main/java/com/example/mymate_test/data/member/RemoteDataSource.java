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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource { // API를 통해 데이터 소스를 가져오는 객체
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private MemberService service = retrofit.create(MemberService.class);

    /** 회원가입 */
    public void createUser(User user, Repository.GetDataCallback<SignUpResponse> callback) {
        // 인터페이스 구현
        service.createUser(user).enqueue(new Callback<SignUpResponse>() {
            @Override
            public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                if (response.isSuccessful()) {
                    callback.onSuccess(response.body());
                }
            }
            @Override
            public void onFailure(Call<SignUpResponse> call, Throwable t) { // 요청 실패
                callback.onFailure(t);
            }
        });
    }

    /** 로그인 */
    public void login(LoginRequest loginRequest, Repository.GetDataCallback<LoginResponse> callback) {
        // 인터페이스 구현
        service.login(loginRequest).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) { callback.onSuccess(response.body()); }
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) { callback.onFailure(t); }
        });
    }

    public void createType(TypeRequest typeRequest, Repository.GetDataCallback<TypeResponse> callback){
        service.createType(typeRequest).enqueue(new Callback<TypeResponse>() {
            @Override
            public void onResponse(Call<TypeResponse> call, Response<TypeResponse> response) {
                if(response.isSuccessful()){
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<TypeResponse> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public void getMy(Long id, Repository.GetDataCallback<MyResponse> callback){
        service.getMy(id).enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                if(response.isSuccessful()){
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public void getDetail(Long id, Repository.GetDataCallback<DetailResponse> callback){
        service.getDetail(id).enqueue(new Callback<DetailResponse>(){
            @Override
            public void onResponse(Call<DetailResponse> call, Response<DetailResponse> response){
                if(response.isSuccessful()){
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<DetailResponse> call, Throwable t){
                callback.onFailure(t);
            }
        });
    }


    public void createDetail(DetailRequest detailRequest, Repository.GetDataCallback<Void> callback){
        service.createDetail(detailRequest).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

    public void getRecommendMateList(Long memberId, String mateType1, Repository.GetDataCallback<GetRecommendMateListResponse> callback){
        service.getRecommendMateList(memberId,mateType1).enqueue(new Callback<GetRecommendMateListResponse>() {
            @Override
            public void onResponse(Call<GetRecommendMateListResponse> call, Response<GetRecommendMateListResponse> response) {
                if(response.isSuccessful()){
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<GetRecommendMateListResponse> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }

}
