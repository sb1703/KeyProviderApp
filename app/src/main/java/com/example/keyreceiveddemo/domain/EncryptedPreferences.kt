package com.example.keyreceiveddemo.domain

import com.example.keyreceiveddemo.model.Keys

interface EncryptedPreferences {
    fun saveEncryptedData(keys: Keys): Boolean
    fun readEncryptedData(): Keys?
    fun areApiKeysReady(): Boolean
}