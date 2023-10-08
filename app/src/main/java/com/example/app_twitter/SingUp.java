package com.example.app_twitter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;

import com.example.app_twitter.Database.Database1;
import com.example.app_twitter.databinding.ActivitySingUpBinding;
import com.example.app_twitter.users.user;

public class SingUp extends AppCompatActivity {
    ActivitySingUpBinding binding;
    Database1 database;
    boolean nameboolean = false;
    boolean UsersNameboolean = false;
    boolean passwordboolean = false;
    boolean Emailboolean = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivitySingUpBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        database = new Database1(this);
        binding.SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplication(), SignIn.class);
                startActivity(intent);
            }
        });
        binding.EmailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.EmailEditText.setBackgroundResource(R.drawable.sign_2);
                binding.name.setBackgroundResource(R.drawable.sign_1);
                binding.Usersname.setBackgroundResource(R.drawable.sign_1);
                binding.passwordEditText.setBackgroundResource(R.drawable.sign_1);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.Usersname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.EmailEditText.setBackgroundResource(R.drawable.sign_1);
                binding.name.setBackgroundResource(R.drawable.sign_1);
                binding.Usersname.setBackgroundResource(R.drawable.sign_2);
                binding.passwordEditText.setBackgroundResource(R.drawable.sign_1);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.EmailEditText.setBackgroundResource(R.drawable.sign_1);
                binding.name.setBackgroundResource(R.drawable.sign_2);
                binding.Usersname.setBackgroundResource(R.drawable.sign_1);
                binding.passwordEditText.setBackgroundResource(R.drawable.sign_1);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                binding.EmailEditText.setBackgroundResource(R.drawable.sign_1);
                binding.name.setBackgroundResource(R.drawable.sign_1);
                binding.Usersname.setBackgroundResource(R.drawable.sign_1);
                binding.passwordEditText.setBackgroundResource(R.drawable.sign_2);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        binding.Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = binding.name.getText().toString();
                String UsersName = binding.Usersname.getText().toString();
                String password = binding.passwordEditText.getText().toString();
                String Email = binding.EmailEditText.getText().toString();
                if (name.isEmpty()) {
                    binding.name.setError("Please enter your name");
                    nameboolean = false;
                } else {
                    nameboolean = true;
                }
                if (UsersName.isEmpty()) {
                    binding.Usersname.setError("Please enter your UsersName");
                    UsersNameboolean = false;
                } else {
                    UsersNameboolean = true;
                }

                if (!(name.length() >= 3)) {
                    binding.name.setError("Enter a name of 3 or more characters");
                    nameboolean = false;
                } else {
                    nameboolean = true;
                }
//
                if (!(isValidEmail(Email))) {
                    binding.EmailEditText.setError("Please enter your Email");
                    Emailboolean = false;
                } else {
                    Emailboolean = true;
                }
                if (password.isEmpty()) {
                    binding.passwordEditText.setError("Please enter your Password");
                    passwordboolean = false;
                } else {
                    passwordboolean = true;
                }

                if (!(password.length() >= 5)) {
                    binding.passwordEditText.setError("Enter a password of 6 or more characters");
                    passwordboolean = false;
                } else {
                    passwordboolean = true;
                }
                System.out.println("----------------------------------------------------------------");
                System.out.println(database.isExists(Email, Database1.COLUMN_New_Email));
                System.out.println("--------------------------------------------");
                if (password.length() >= 5 && nameboolean && passwordboolean && UsersNameboolean && Emailboolean) {
                    if (database.isExists(Email, Database1.COLUMN_New_Email)) {
                        if (database.isExists(UsersName, Database1.COLUMN_New_Username)) {
                            if (hasNoSpaces(UsersName)) {
                                user user = new user(name, UsersName, Email, password);
                                Insert(user);
                            } else {
                                binding.Usersname.setError("Can't exist username hasNoSpaces");
                            }

                        } else {
                            binding.Usersname.setError("There is a similar Usersname, please enter another one");
                        }
                    } else {
                        binding.EmailEditText.setError("There is a similar Email, please enter another one");
                    }


                }

            }
        });


    }

    void Insert(user user) {
        if (database.insertUser(user)) {
            Intent intent1 = new Intent(SingUp.this, SignIn.class);
            startActivity(intent1);
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(SingUp.this);
            builder.setTitle("Wrong").setMessage("There is a problem with storage in databases!!");
            builder.show();
        }
    }

    public static boolean hasNoSpaces(String word) {
        // استخدم دالة contains للبحث عن مساحات فارغة في الكلمة
        if (word.contains(" ")) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}