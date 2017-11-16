package org.tec.datos.packettecapp.register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;

import org.json.JSONException;
import org.json.JSONObject;
import org.tec.datos.packettecapp.R;
import org.tec.datos.packettecapp.User;

import com.bumptech.glide.Glide;


import java.security.MessageDigest;
//3Uj1oG7ANZ1IeEoHlWxv7wOHmb8=

public class AccountActivity extends AppCompatActivity {
    private ImageView photoImageView;
    private TextView nameTextView;
    private TextView emailTextView;
    private TextView idTextView;
    private User newUser;

    private ProfileTracker profileTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        photoImageView = (ImageView) findViewById(R.id.photoImageView);
        nameTextView = (TextView) findViewById(R.id.nameTextView);
        emailTextView = (TextView) findViewById(R.id.emailTextView);
        idTextView = (TextView) findViewById(R.id.idTextView);

        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile currentProfile) {
                if (currentProfile != null) {
                    displayProfileInfo(currentProfile);
                }
            }
        };

        if (AccessToken.getCurrentAccessToken() == null) {
            goLoginScreen();
        } else {
            requestEmail(AccessToken.getCurrentAccessToken());

            Profile profile = Profile.getCurrentProfile();
            if (profile != null) {
                displayProfileInfo(profile);
            } else {
                Profile.fetchProfileForCurrentAccessToken();
            }
        }
    }

    private void requestEmail(AccessToken currentAccessToken) {
        GraphRequest request = GraphRequest.newMeRequest(currentAccessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                if (response.getError() != null) {
                    Toast.makeText(getApplicationContext(), response.getError().getErrorMessage(), Toast.LENGTH_LONG).show();
                    return;
                }
                try {
                    String email = object.getString("email");
                    setEmail(email);
                    newUser.setEmail(email);
                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id, first_name, last_name, email, gender, birthday, location");
        request.setParameters(parameters);
        request.executeAsync();
    }

    private void setEmail(String email) {
        emailTextView.setText(email);
    }

    private void goLoginScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void logout(View view) {
        LoginManager.getInstance().logOut();
        goLoginScreen();
    }

    private void displayProfileInfo(Profile profile) {
        String id = profile.getId();
        String name = profile.getName();
        String photoUrl = profile.getProfilePictureUri(200, 200).toString();
        newUser= new User(name);

        nameTextView.setText(name);
        idTextView.setText(id);

        Glide.with(getApplicationContext())
                .load(photoUrl)
                .into(photoImageView);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        profileTracker.stopTracking();
    }



    public String KeyHashes() {
        PackageInfo info;
        String KeyHashes= null;
        try{
            info = getPackageManager().getPackageInfo("org.tec.datos.packettecapp", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures){
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                KeyHashes = new String(Base64.encode(md.digest(),0));

            }
        }catch (Exception e){
            e.printStackTrace();
        }return KeyHashes;
    }


}
