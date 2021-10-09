package ru.sikuda.mobile.start13_menu

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val MENU_COLOR_RED = 1
    val MENU_COLOR_GREEN = 2
    val MENU_COLOR_BLUE = 3

    val MENU_SIZE_22 = 4
    val MENU_SIZE_26 = 5
    val MENU_SIZE_30 = 6

    lateinit var tvColor: TextView
    lateinit var tvSize: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvColor = findViewById(R.id.tvColor)
        tvSize  =  findViewById(R.id.tvSize)

        // register tvColor и tvSize to menu
        registerForContextMenu(tvColor)
        registerForContextMenu(tvSize)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menuaction, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.item1 -> {
                Toast.makeText(this, "Selected Item1", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.item2 -> {
                Toast.makeText(this, "Selected Item2", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        //auto set menu
        val inflater = menuInflater
        inflater.inflate(R.menu.context_menu, menu)

        //add menu by hand
        when (v?.id) {
            R.id.tvColor -> {
                menu?.add(0, MENU_COLOR_RED, 0, "Red")
                menu?.add(0, MENU_COLOR_GREEN, 0, "Green")
                menu?.add(0, MENU_COLOR_BLUE, 0, "Blue")
            }
            R.id.tvSize -> {
                menu?.add(0, MENU_SIZE_22, 0, "22")
                menu?.add(0, MENU_SIZE_26, 0, "26")
                menu?.add(0, MENU_SIZE_30, 0, "30")
            }
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.call ->{
                Toast.makeText(applicationContext, "call code", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.sms ->{
                Toast.makeText(applicationContext, "sms code", Toast.LENGTH_LONG).show()
                return true
            }
        }

        when (item.itemId) {
            MENU_COLOR_RED -> {
                tvColor.setTextColor(Color.RED)
                tvColor.setText("Text color = red")
            }
            MENU_COLOR_GREEN -> {
                tvColor.setTextColor(Color.GREEN)
                tvColor.setText("Text color = green")
            }
            MENU_COLOR_BLUE -> {
                tvColor.setTextColor(Color.BLUE)
                tvColor.setText("Text color = blue")
            }
            MENU_SIZE_22 -> {
                tvSize.setTextSize(22F)
                tvSize.setText("Text size = 22")
            }
            MENU_SIZE_26 -> {
                tvSize.setTextSize(26F)
                tvSize.setText("Text size = 26")
            }
            MENU_SIZE_30 -> {
                tvSize.setTextSize(30F)
                tvSize.setText("Text size = 30")
            }
        }
        return super.onContextItemSelected(item)
    }
}

