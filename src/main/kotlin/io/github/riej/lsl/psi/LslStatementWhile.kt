package io.github.riej.lsl.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import io.github.riej.lsl.parser.LslTypes

class LslStatementWhile(node: ASTNode) : ASTWrapperPsiElement(node), LslStatement {
    val condition: LslExpression?
        get() = this.findChildByType(LslTypes.EXPRESSIONS)

    val statement: LslStatement?
        get() = this.findChildByType(LslTypes.STATEMENTS)
}