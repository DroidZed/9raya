package tn.esprit.curriculumvitaev2

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.util.Patterns
import android.view.inputmethod.EditorInfo.IME_ACTION_DONE
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import tn.esprit.curriculumvitaev2.utils.CvObject
import tn.esprit.curriculumvitaev2.utils.hideKeyboard
import tn.esprit.curriculumvitaev2.utils.on


class MainActivity : AppCompatActivity() {

    private lateinit var fNameTextLayout: TextInputLayout
    private lateinit var emailTextLayout: TextInputLayout
    private lateinit var ageTextLayout: TextInputLayout
    private lateinit var imageBorder: ImageView
    private lateinit var profileImage: ImageView

    private lateinit var radioGroup: RadioGroup
    private lateinit var checkedRadioButton: RadioButton
    private lateinit var nextBtn: Button

    private lateinit var layoutTitle: TextView

    private val cv = CvObject()

    private val pickImage = 100

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == pickImage) {
            profileImage.setImageURI(data?.data)
            cv.imgURI = data?.data
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fNameTextLayout = findViewById(R.id.fullNameTxtInput)
        emailTextLayout = findViewById(R.id.emailTxtInput)
        ageTextLayout = findViewById(R.id.ageTxtInput)

        radioGroup = findViewById(R.id.radioGroup)
        nextBtn = findViewById(R.id.nxtBtn)
        imageBorder = findViewById(R.id.borderImg)
        layoutTitle = findViewById(R.id.layoutTitle)

        profileImage = findViewById(R.id.profileImage)

        supportActionBar?.title = resources.getString(R.string.title1)

        val inputLayouts = mutableListOf(
            fNameTextLayout,
            emailTextLayout,
            ageTextLayout
        )

        val inputs = inputLayouts.map { t -> t.editText }


        val ageInput = inputs.first { it?.id == R.id.ageInput }
        val emailInput = inputs.first { it?.id == R.id.emailInput }

        // Event listeners
        ageInput?.on(IME_ACTION_DONE) {
            ageInput.apply {
                clearFocus()
                hideKeyboard()
            }
        }

        profileImage.setOnClickListener {

            val gallery = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            startActivityForResult(gallery, pickImage)
        }


        nextBtn.setOnClickListener {
            val checkedID: Int = radioGroup.checkedRadioButtonId

            when {

                cv.imgURI == null -> {

                    Toast.makeText(
                        this,
                        "Please select an image !",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }

                checkedID == -1 -> {
                    imageBorder.setImageResource(R.drawable.background_border_red)
                    layoutTitle.setTextColor(resources.getColor(R.color.errorRed))
                }

                !Patterns.EMAIL_ADDRESS.matcher(emailInput!!.text.toString()).matches() -> {
                    emailTextLayout.apply {
                        isErrorEnabled = true
                        error = "Invalid email !"
                    }
                }

                inputs.any { it?.text?.isBlank()!! } -> {
                    inputLayouts.forEach {
                        if (it.editText?.text?.isBlank()!!) {
                            it.apply {
                                isErrorEnabled = true
                                when (id) {
                                    R.id.fullNameTxtInput -> it.error =
                                        "Full name mustn't be blank !"
                                    R.id.emailTxtInput -> it.error = "Email name mustn't be blank !"
                                    R.id.ageTxtInput -> it.error = "Age mustn't be blank !"
                                }
                            }
                        }
                    }
                }

                else -> {
                    inputLayouts.filter { it.isErrorEnabled }
                        .forEach {
                            it.apply {
                                isErrorEnabled = false;
                                error = ""
                            }
                        }
                    checkedRadioButton = findViewById(checkedID)
                    imageBorder.setImageResource(R.drawable.background_border)
                    layoutTitle.setTextColor(resources.getColor(R.color.colorPrimaryDark))


                    cv.fullName = fNameTextLayout.editText?.text.toString()
                    cv.email = emailTextLayout.editText?.text.toString()
                    cv.age = Integer.parseInt(ageTextLayout.editText?.text.toString())
                    cv.gender = checkedRadioButton.text.toString()

                    Intent(this, FormPart2::class.java).let { i ->
                        i.putExtra("cv", cv)
                        startActivity(i)
                    }

                }
            }
        }

    }
}