package io.github.riej.lsl.psi

import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.lang.ASTNode
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.navigation.ItemPresentation
import io.github.riej.lsl.LslIcons
import io.github.riej.lsl.annotation.fixes.DeleteElementsFix
import javax.swing.Icon

class LslStateCustom(node: ASTNode) : ASTWrapperLslNamedElement(node), LslState, ItemPresentation, LslScopedElement {
    override fun getPresentableText(): String = "state $name"

    override fun getIcon(unused: Boolean): Icon = LslIcons.STATE

    override fun annotate(holder: AnnotationHolder) {
        if ((containingFile as? LslFile)?.kwdbData?.events?.get(name) != null) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Reserved identifier")
                .create()
            return
        }

        super<LslState>.annotate(holder)

        val identifyingElement = identifyingElement
        if (identifyingElement != null && usages.isEmpty()) {
            holder.newAnnotation(HighlightSeverity.WEAK_WARNING, "Unused state")
                .highlightType(ProblemHighlightType.LIKE_UNUSED_SYMBOL)
                .withFix(DeleteElementsFix(listOf(this), "Remove state"))
                .range(identifyingElement.textRange)
                .create()
        }
    }
}