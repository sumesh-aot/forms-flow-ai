"""Added submission_id and latest_form_id

Revision ID: d457f753885f
Revises: 6dd998fc6fed
Create Date: 2022-07-13 13:13:28.032976

"""
from alembic import op
import sqlalchemy as sa


# revision identifiers, used by Alembic.
revision = 'd457f753885f'
down_revision = '6dd998fc6fed'
branch_labels = None
depends_on = None

conn = op.get_bind()
form_url_exists = conn.execute("SELECT EXISTS (SELECT 1 FROM information_schema.columns WHERE table_schema='public' AND table_name='application' AND column_name='form_url');")
form_url_exists = form_url_exists.fetchone()[0]
def upgrade():
    # ### commands auto generated by Alembic - please adjust! ###
    op.add_column('application', sa.Column('submission_id', sa.String(length=100), nullable=True))
    op.add_column('application', sa.Column('latest_form_id', sa.String(length=100), nullable=True))
    if(form_url_exists):
        op.execute("update application set submission_id = substring(application.form_url, position('/submission/' in application.form_url)+12) where application.submission_id is null and application.application_status != 'Draft'")
        op.execute("update application set latest_form_id = substring(application.form_url,position('/form/' in application.form_url)+6 ,24) where application.latest_form_id is null")
    op.alter_column('application', 'latest_form_id', nullable=False)
    
    op.add_column('application_audit', sa.Column('form_id', sa.String(length=100), nullable=True))
    op.add_column('application_audit', sa.Column('submission_id', sa.String(length=100), nullable=True))
    op.execute("update application_audit set submission_id = substring(application_audit.form_url, position('/submission/' in application_audit.form_url)+12) where application_audit.submission_id is null")
    op.execute("update application_audit set form_id = substring(application_audit.form_url,position('/form/' in application_audit.form_url)+6 ,24) where application_audit.form_id is null")
    op.alter_column('application_audit', 'form_id', nullable=False)
    op.alter_column('application_audit', 'submission_id', nullable=False)

    # Dropping 'form_url' should be done after stable release 
    # op.drop_column('application', 'form_url')
    # op.drop_column('application_audit', 'form_url')
    # ### end Alembic commands ###


def downgrade():
    # ### commands auto generated by Alembic - please adjust! ###
    # op.add_column('application', sa.Column('form_url', sa.VARCHAR(length=500), autoincrement=False, nullable=True))
    op.drop_column('application', 'latest_form_id')
    op.drop_column('application', 'submission_id')
    # ### end Alembic commands ###
