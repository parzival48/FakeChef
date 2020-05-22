package com.parzival48.fakechef.ui.dialog

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.parzival48.fakechef.R

class AlertPopup(private val title: String, private val message: String) : DialogFragment() {

    private lateinit var txtTitle : TextView
    private lateinit var txtMessage : TextView
    lateinit var btnOkay : TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_alert_popup, container)
    }

    override fun onStart() {
        super.onStart()
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.MATCH_PARENT
        dialog?.window?.setLayout(width, height)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog?.apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
            window?.setBackgroundDrawableResource(R.color.transparent)
        }
        setStyle(STYLE_NO_INPUT, android.R.style.Theme)
        txtTitle = view.findViewById(R.id.alert_title)
        txtMessage = view.findViewById(R.id.alert_message)
        btnOkay = view.findViewById(R.id.btn_okay)
        txtTitle.text = this.title
        txtMessage.text = this.message
        btnOkay.setOnClickListener {
            activity!!.finish()
        }
    }

}