package com.example.easysushi.core

import com.example.easysushi.R

enum class LoaderState(val message: String?) {
    DISABLE(message = null),
    STANDARD_LOADING(message = ResResolver.getString(R.string.loading)),
    WARES_LOADING(message = ResResolver.getString(R.string.wares_loading))
}
